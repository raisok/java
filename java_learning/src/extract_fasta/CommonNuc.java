package extract_fasta;

import java.util.HashMap;

public class CommonNuc
{
  public static String format(String seq)
  {
    return format(seq, 60);
  }

  public static String format(String seq, int len) {
    StringBuilder seqTemp = new StringBuilder();
    char[] seqCharArr = seq.toCharArray();
    int charSize = seqCharArr.length;
    int curEffectiveBasesCount = 0;
    for (int i = 1; i <= charSize; i++) {
      char curC = seqCharArr[(i - 1)];
      if ((curC != '\n') && (curC != ' ') && (curC != '\r') && (curC != '\t'))
      {
        curEffectiveBasesCount++;
        seqTemp.append(curC);
        if (curEffectiveBasesCount % len == 0) {
          seqTemp.append("\n");
        }
      }
    }

    if (seqTemp.charAt(seqTemp.length() - 1) == '\n') {
      seqTemp.deleteCharAt(seqTemp.length() - 1);
    }
    return seqTemp.toString();
  }

  public static String reverse(String inSeq) {
    return new StringBuilder(inSeq).reverse().toString();
  }

  public static String complement(String inSeq, boolean isRNA) {
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

    comMap.put(Character.valueOf('-'), Character.valueOf('-'));

    for (int index = 0; index < inSeq.length(); index++) {
      char c = inSeq.charAt(index);

      if (comMap.containsKey(Character.valueOf(c)))
        newSeq.append(comMap.get(Character.valueOf(c)));
      else if ((c != '\n') && (c != '\r') && (c != ' ') && (c != '\t'))
      {
        if (Character.isLowerCase(c))
          newSeq.append('n');
        else {
          newSeq.append('N');
        }
      }
    }
    if (isRNA) {
      return newSeq.toString().replace('T', 'U').replace('t', 'u');
    }
    return newSeq.toString();
  }

  public static String RC(String inSeq, boolean isRNA) {
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

    comMap.put(Character.valueOf('-'), Character.valueOf('-'));

    for (int index = inSeq.length() - 1; index >= 0; index--) {
      char c = inSeq.charAt(index);

      if (comMap.containsKey(Character.valueOf(c)))
        newSeq.append(comMap.get(Character.valueOf(c)));
      else if ((c != '\n') && (c != '\r') && (c != ' ') && (c != '\t'))
      {
        if (Character.isLowerCase(c))
          newSeq.append('n');
        else {
          newSeq.append('N');
        }
      }
    }
    if (isRNA) {
      return newSeq.toString().replace('T', 'U').replace('t', 'u');
    }

    return format(newSeq.toString());
  }
}