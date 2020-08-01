public class VotingMachine
{
   //-----------Start below here. To do: approximate lines of code = 23
   //
   /**
    * Create 4 instance variables. Two are of type String and
    * each stores the name of a political party 
    * Two are of type int and they store the number of votes for 
    * each political party
   */
   String party1;
   String party2;
   int party1votes;
   int party2votes;
   
   
   
   
   /**
      Create a constructor method that has 2 String arguments which 
      are used to initialize the name of each political party
      Set the number of votes for each party to 0
   */
   
   VotingMachine(String party1, String party2){
    this.party1 = party1;
    this.party2 = party2;
    this.party2votes = 0;
    this.party1votes = 0;
   }
   
   
   
   
   
   
   
   /**
      Create a public method voteParty1() which adds one vote for political
      party 1
   */
   void voteParty1(){
    this.party1votes++;
   }
   
   
   
   
   /**
     Create a public method voteParty2() which adds one vote for political
      party 2
   */
   
   void voteParty2(){
    this.party2votes++;
   }
   
   
   /**
    * Create a public method newElection() that sets the current number of votes for 
    * each political party to 0
    */
   public void newElection(){
    this.party2votes = 0;
    this.party1votes = 0;
   }
   
   
   
   
   /**
    * Create a public method getWinner() that returns a String.
    * If party 1 has more votes than party 2 then return the string 
    * containing: the name of party 1 followed by " win the election with "
    * followed by the number of votes for party 1 followed by " Votes"
    * 
    * If party 2 has more votes than party 1 then return the string 
    * containing: the name of party 2 followed by " win the election with "
    * followed by the number of votes for party 2 followed by " Votes"
    * 
    * If party 2 has the same votes as party 1 then return the string 
    * containing: the name of party 1 followed by " and " followed by
    * the name of party 2 followed by " tied with " followed by the 
    * number of votes for party 1
    */
    public String getWinner(){
      if (this.party1votes>this.party2votes)
        return this.party1+" win the election with "+this.party1votes+" Votes";
      else if (this.party2votes>this.party1votes)
        return this.party2+" win the election with "+this.party2votes+" Votes";
      else
        return this.party1+" and "+this.party2+" tied with "+this.party1votes;
    }
   
   
   
   
   
   
   
   
   //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
