package CSC_340.Assignment2;

public class randomJoke {
    public String setup;
    public String punchline;


    public randomJoke(String setup,String punchline){
        this.setup = setup;
        this.punchline = punchline;
    }

    public String getSetup(){return setup;}
    public void setSetup(String setup){this.setup = setup;}

    public String getPunchline(){return punchline;};
    public void setPunchline(String punchline){this.punchline = punchline;}
}
