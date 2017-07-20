package extract_fasta;


import extract_fasta.CommonNuc;
import java.io.PrintStream;
import java.util.HashMap;

public class Fasta
{
  private String seq = "";
  private String id = "";

  public String toString()
  {
    return new StringBuilder().append(">").append(this.id).append("\n").append(this.seq).toString();
  }

  public Fasta setSeq(String seq)
  {
    this.seq = seq;
    return this;
  }

  public Fasta setId(String id) {
    this.id = id.trim().replaceFirst("^>", "");
    return this;
  }

  public Fasta()
  {
  }

  public Fasta(String id, StringBuffer seq)
  {
    setId(id);
    setSeq(seq.toString());
  }

  public Fasta(String id, String seq) {
    setId(id);
    setSeq(seq);
  }

  public String getId()
  {
    return this.id;
  }

  public String getFormatId()
  {
    return this.id.replaceFirst("^>", "").split("\\s+", 2)[0];
  }

  public String getSeq()
  {
    return this.seq;
  }

  public String getFormatSeq()
  {
    return getFormatSeq(60);
  }

  public String getFormatSeq(int len)
  {
    return CommonNuc.format(this.seq, len);
  }

  public String getReverse()
  {
    StringBuilder newString = new StringBuilder(this.seq);
    return newString.reverse().toString();
  }

  public String getComplement() {
    StringBuilder newSeq = new StringBuilder();
    HashMap comMap = new HashMap();
    comMap.put(Character.valueOf('A'), Character.valueOf('T'));
    comMap.put(Character.valueOf('a'), Character.valueOf('t'));
    comMap.put(Character.valueOf('T'), Character.valueOf('A'));
    comMap.put(Character.valueOf('t'), Character.valueOf('a'));
    comMap.put(Character.valueOf('C'), Character.valueOf('G'));
    comMap.put(Character.valueOf('c'), Character.valueOf('g'));
    comMap.put(Character.valueOf('G'), Character.valueOf('C'));
    comMap.put(Character.valueOf('g'), Character.valueOf('c'));

    comMap.put(Character.valueOf('U'), Character.valueOf('A'));
    comMap.put(Character.valueOf('u'), Character.valueOf('a'));

    for (int index = 0; index < this.seq.length(); index++) {
      char c = this.seq.charAt(index);

      if (comMap.containsKey(Character.valueOf(c)))
        newSeq.append(comMap.get(Character.valueOf(c)));
      else if ((c != '\n') && (c != '\r') && (c != ' '))
      {
        if (Character.isLowerCase(c))
          newSeq.append('n');
        else
          newSeq.append('N');
      }
    }
    return newSeq.toString();
  }

  public String getRevAndComp() {
    return new Fasta(this.id, getReverse()).getComplement();
  }

  public static void main(String[] args) {
    Fasta fasta2 = new Fasta("record_name", "ATTTCAAGCCAAGCTTGAGCTGAGATAAACTTGTTTCCACCTCTATACTTGACTTGCCAAGAGATAATGCGGTGATGACTAGTTAGTTTATTCAGCTGGTACATCATCTCAACATTTATATTATTCATTTATTTCATTATCTTGAAGGGTTGATTTGACAGCTGAATAATTTGTGGTCTCGTCATGTCAAAGAGAAGAATTACTTGCCGTGCCATGTCTAAAGGAACGATATGGGAGCTA");
    System.out.println(new StringBuilder().append(">").append(fasta2.getId()).append("\n").append(fasta2.getFormatSeq(11)).toString());
  }
}