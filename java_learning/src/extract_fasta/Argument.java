package extract_fasta;


class Argument
{
  private String name;
  private String value;
  private String description;
  private boolean isSet;

  public String getName()
  {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value)
  {
    this.isSet = true;
    this.value = value;
  }

  public boolean isSeted() {
    return this.isSet;
  }

  public void setIsSeted(boolean isSet) {
    this.isSet = isSet;
  }

  public String getDescription()
  {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Argument()
  {
    this.name = "";
    this.value = "[Unsetted]";
    this.description = "";
    this.isSet = false;
  }
}