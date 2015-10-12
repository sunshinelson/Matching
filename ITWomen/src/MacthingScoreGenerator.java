/**
 * 
 */

/**
 * @author Davina
 *
 */
public class MacthingScoreGenerator {

	public int scoreTable (Mentee m, Mentor mr){
		Mentee mentee = m;
		Mentor mentor = mr;
		
		int totalScore = 0;
		
		totalScore = totalScore 
		+ 6 * languageMatching(mentee.getPrefLanguage(), mentor.isEnglish(), 
		mentor.isFrench(), mentor.isGerman(), mentor.isItalian(), mentor.getOtherLanguage(), mentor.getPrefLanguage());

		totalScore = totalScore 
		+ 6 * languageMatching(mentor.getPrefLanguage(), mentee.isEnglish(), 
		mentee.isFrench(), mentee.isGerman(), mentee.isItalian(), mentee.getOtherLanguage(), mentee.getPrefLanguage());
		
		totalScore = totalScore 
		+ 5 * clientFacingMatching(mentor.getClientFacing(), mentee.getClientFacingRoleImportant());
		
		totalScore = totalScore 
		+ 4 * matchOfBusChoice(mentor.getBusArea(), mentee.getFirstChoicebusiness(), mentee.getSecoundChoiceBusiness());
				
		totalScore = totalScore 
		+ 4 * matchOfBusChoice(mentee.getBusArea(), mentor.getFirstChoicebusiness(), mentor.getSecoundChoiceBusiness());
		
		totalScore = totalScore 
		+ 3 * matchOfKnowledge(mentor.getKnowleageArea(), mentee.getKnowleageArea());
		
		totalScore = totalScore 
		+ 2 * matchLengthOfService(mentor.getDuration(), mentee.getDuration()); 
		
		totalScore = totalScore 
		+ 1 * matchingOfTeamSize(mentor.getGroupSize(), mentee.getGroupSize());
		
		return totalScore;
	}
	
	/*
	 * Überprüft wie hoch der Sprachen-Matching-Score ist
	 * @return score mach-crit 1 (a&b)
	 */
	private int languageMatching(String prefered, boolean english, boolean french, boolean german, boolean italian, String other, String preferedL){
		int i = 0;
		
		if( prefered.equals(preferedL)){
			i=30;
		}else{
			switch (prefered){
				case "English":
					if(english)
						i = 20;
				case "German":
					if(german)
						i = 20;
				case "French":
					if(french)
						i = 20;
				case "Italian":	
					if(italian)
						i = 20;
			}
		}
		
		return i;
	}
	/*
	 * Überprüft wie hoch der client-Factor-Score ist
	 * @return score mach-crit 2
	 */
	private int clientFacingMatching(String clientFacing, String important){
		int i = 0;	
		if(clientFacing.equals(important)){
			i = 30;
		}
		return i;
	}
	/*
	 * Überprüft wie hoch der Business-Area-Matching-Score ist
	 * @return score mach-crit 3 (a & b)
	 */
	private int matchOfBusChoice(String busArea, String firstChoicebusiness, String secoundChoiceBusiness){
		int i = 0;
		
		if(busArea.equals(firstChoicebusiness)){
			i = 30;
		}else if(busArea.equals(secoundChoiceBusiness)){
			i = 20;
		}
		return i;
	}
	/*
	 * Überprüft wie hoch der Business-Knowledge-Score ist
	 * @return score mach-crit 4 
	 */
	private int matchOfKnowledge(String knowledge, String knowledgeChoice){
		int i = 0;
		if(knowledge.equals(knowledgeChoice)){
			i = 30;
		}
		return i;
	}
	/*
	 * Überprüft wie hoch der Arbeitslänge-Score ist
	 * @return score mach-crit 5 
	 */
	private int matchLengthOfService(String length, String preferedLength){
		int i = 0;
		if(length.equals(preferedLength)){
			i = 30;
		}
		return i;
	}
	/*
	 * Überprüft wie hoch der Teamgrösse-Score ist
	 * @return score mach-crit 6 
	 */
	private int matchingOfTeamSize(String size, String preferedSize){
		int i = 0;
		if(size.equals(preferedSize)){
			i = 30;
		}
		return i;
	}
	
}
