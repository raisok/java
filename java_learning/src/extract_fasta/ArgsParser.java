package extract_fasta;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ArgsParser
{
  String errInfo = "[Error]:\n";
  String helpInfo = "[Usage]:\n";
  HashMap<String, Argument> argsStore = new HashMap();

  ArrayList<String> argsRank = new ArrayList();

  public static void main(String[] args)
  {
  }

  public String getValue(String name)
  {
    return ((Argument)this.argsStore.get(name)).getValue();
  }

  public void setValue(String name, String value)
  {
    ((Argument)this.argsStore.get(name)).setValue(value);
  }

  public void addArgs(String name, String description)
  {
    Argument argN = new Argument();
    argN.setName(name);
    argN.setDescription(description);
    this.argsStore.put(name, argN);
    this.argsRank.add(name);
  }

  public void addArgs(String name, String descritption, String value)
  {
    Argument argN = new Argument();
    argN.setName(name);
    argN.setValue(value);
    argN.setDescription(descritption);
    this.argsStore.put(name, argN);
    this.argsRank.add(name);
  }

  public String getErrInfo()
  {
    return this.errInfo;
  }

  public String getHelpinfo()
  {
    for (String name : this.argsRank) {
      if (!((Argument)this.argsStore.get(name)).isSeted())
        this.helpInfo = (this.helpInfo + "\t" + name + "\t" + ((Argument)this.argsStore.get(name)).getDescription() + " [Required]\n");
      else {
        this.helpInfo = (this.helpInfo + "\t" + name + "\t" + ((Argument)this.argsStore.get(name)).getDescription() + " [Default:" + ((Argument)this.argsStore.get(name)).getValue() + "]\n");
      }
    }

    return this.helpInfo;
  }

  public boolean parseArgs(String[] args)
  {
    int agrsLen = args.length;
    if (agrsLen % 2 != 0) {
      this.errInfo += "Please provided arguments in correct format";
      return false;
    }
    for (int index = 0; index < agrsLen; index += 2) {
      String name = args[index];
      String value = args[(index + 1)];
      if (this.argsStore.containsKey(name)) {
        setValue(name, value);
      } else {
        this.errInfo = (this.errInfo + " invalid aruguments " + name);
        return false;
      }

    }

    for (String name : this.argsStore.keySet()) {
      if (!((Argument)this.argsStore.get(name)).isSeted()) {
        this.errInfo = (this.errInfo + "\tArgument [" + name + "] Should be Setted");
        return false;
      }

    }

    return true;
  }

  public void printAllArgs()
  {
    System.out.println("[All Args Info]:");
    for (String name : this.argsStore.keySet())
      System.out.println("\t" + name + "\t" + ((Argument)this.argsStore.get(name)).getValue());
  }
}