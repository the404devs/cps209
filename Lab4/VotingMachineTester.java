import java.util.Random;

public class VotingMachineTester 
{
	public static void main(String[] args)
	{
		VotingMachine vm = new VotingMachine("Democrats","Republicans");
		
		int  votes1 = 7736;
		for (int i = 0; i < votes1; i++)
			vm.voteParty1();
		
		int votes2 = 7624;
		for (int i = 0; i < votes2; i++)
			vm.voteParty2();
		
		// Expected Output:
		// Party1 votes 7736
		// Party2 votes 7624
		// Democrats win the election with 7736 Votes
		System.out.println("Party1 votes " + votes1);
		System.out.println("Party2 votes " + votes2);
		System.out.println(vm.getWinner());
		
		// Expected Output:
		// Democrats and Republicans tied with 1
		vm.newElection();
		vm.voteParty1();
		vm.voteParty2();
		System.out.println(vm.getWinner());
	}
}
