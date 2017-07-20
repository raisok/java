package extract_fasta;

import extract_fasta.Fasta;
import extract_fasta.FastaReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import extract_fasta.ArgsParser;

public class ExtractFasta
{
  private ArrayList<String> idList;
  private FastaReader far;
  private Fasta extractedFasta;
  private HashSet<String> seenId = new HashSet();

  public HashSet<String> getSeenId()
  {
    return this.seenId;
  }

  public void setSeenId(HashSet<String> seenId) {
    this.seenId = seenId;
  }

  public FastaReader getFar()
  {
    return this.far;
  }

  public void setFar(FastaReader far) {
    this.far = far;
  }

  public Fasta getExtractedFasta() {
    return this.extractedFasta;
  }

  public void setExtractedFasta(Fasta extractedFasta) {
    this.extractedFasta = extractedFasta;
  }

  public ArrayList<String> getIdList() {
    return this.idList;
  }

  public void setIdList(ArrayList<String> idList) {
    this.idList = idList;
  }

  public Fasta getNextMeet() {
    return this.extractedFasta;
  }

  public boolean hasNextMeet() throws IOException
  {
    return (this.far.hasNext()) && (getFasta());
  }

  private boolean getFasta()
    throws IOException
  {
    while (this.far.hasNext()) {
      Fasta curFasta = this.far.getNext();
      if (this.idList.contains(curFasta.getFormatId()))
      {
        this.extractedFasta = curFasta;
        this.seenId.add(curFasta.getFormatId());
        return true;
      }
    }

    return false;
  }

  public ExtractFasta(ArrayList<String> idList, FastaReader far)
  {
    this.idList = idList;
    this.far = far;
  }

  public ExtractFasta(String idListFile, String FastaFilePath, String outFilePath)
    throws FileNotFoundException, IOException
  {
    this.seenId = new HashSet();

    BufferedWriter bw = new BufferedWriter(new FileWriter(outFilePath));

    BufferedReader idReader = new BufferedReader(new FileReader(idListFile));
    this.idList = new ArrayList();
    String inline = null;
    while ((inline = idReader.readLine()) != null) {
      if (!inline.matches("^\\s*$"))
      {
        this.idList.add(inline.trim().replaceFirst("^>", "").split("\\s+")[0]);
      }
    }
    idReader.close();

    FastaReader fr = new FastaReader(FastaFilePath);
    ExtractFasta ef = new ExtractFasta(this.idList, fr);
    while (ef.hasNextMeet())
    {
      Fasta curFasta = ef.getNextMeet();
      bw.write(curFasta.toString());
      this.seenId.add(curFasta.getFormatId());
      bw.flush();
    }

    bw.close();
  }

  public ExtractFasta(ArrayList<String> idList, String FastaFilePath, String outFilePath)
    throws FileNotFoundException, IOException
  {
    this.seenId = new HashSet();

    BufferedWriter bw = new BufferedWriter(new FileWriter(outFilePath));

    FastaReader fr = new FastaReader(FastaFilePath);
    ExtractFasta ef = new ExtractFasta(idList, fr);
    while (ef.hasNextMeet())
    {
      Fasta curFasta = ef.getNextMeet();
      bw.write(curFasta.toString());
      this.seenId.add(curFasta.getFormatId());
      bw.flush();
    }

    bw.close();
  }

  public ArrayList<String> getUnHitId()
  {
    ArrayList unHitId = new ArrayList();
    for (String id : this.idList) {
      if (!this.seenId.contains(id))
      {
        unHitId.add(id);
      }
    }
    return unHitId;
  }

  public static void main(String[] args)
    throws IOException
  {
    ArgsParser ap = new ArgsParser();
    ap.addArgs("--inIDs", "Input Fasta ID list File");
    ap.addArgs("--inFastaFile", "Input Fasta File");
    ap.addArgs("--outFastaFile", "Out Fasta File Name ");

    if (ap.parseArgs(args))
    {
      new ExtractFasta(ap.getValue("--inIDs"), ap.getValue("--inFastaFile"), ap.getValue("--outFastaFile"));
    } else {
      System.err.println(ap.getHelpinfo());
      System.err.println(ap.getErrInfo());
    }
  }
}