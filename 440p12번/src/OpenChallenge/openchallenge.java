package OpenChallenge;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Word {
    private String engWord;
    private String korWord;
    
    Word(String engWord, String korWord) {
    	this.engWord = engWord;
    	this.korWord = korWord;
    }
    
    public String getEngWord() {
    	return engWord;
    }
    
    public String getKorWord() {
    	return korWord;
    }
    public boolean equals(Object o) {
    	Word tmp = (Word) o;
    	if(this.korWord.equals(tmp.getKorWord())&&this.engWord.equals(tmp.getEngWord()))
    		return true;
    	else
    		return false;
    }
}

class WordQuiz {
	private Scanner sc;
    private Vector<Word> v;
    
    WordQuiz() {
    	sc = new Scanner(System.in);
        v = new Vector<Word>();
        v.add(new Word("love", "사랑"));
        v.add(new Word("animal", "동물"));
        v.add(new Word("emotion", "감정"));
        v.add(new Word("painting", "그림"));
        v.add(new Word("bear", "곰"));
        v.add(new Word("eye", "눈"));
        v.add(new Word("society", "사회"));
        v.add(new Word("human", "인간"));
        v.add(new Word("picture", "사진"));
        v.add(new Word("human", "사람"));
        v.add(new Word("error", "오류"));
        v.add(new Word("coffee", "커피"));
        v.add(new Word("doll", "인형"));
        v.add(new Word("stock", "주식"));
        v.add(new Word("smile", "웃음"));
        v.add(new Word("computer", "컴퓨터"));
        }
    
    public void insert() {
    	String userEng, userKor;
    	System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
    	while(true) {
    		System.out.print("영어 한글 입력>>");
    		userEng = sc.next();
    		if(userEng.equals("그만"))
    			System.out.println();
    			break;
    	}
    	userKor = sc.next();
    	
    	Word tmp = new Word(userEng, userKor);
    	if (v.contains(tmp))
    		System.out.println(tmp.getEngWord()+"는 이미 있습니다!");
    	else
    		v.add(tmp);
    	}
    
	public void test() {
		Random r = new Random();
		System.out.println("현재"+v.size()+"개의 단어가 들어있습니다. -1을 입력하면 테스트를 종료합니다.");
		while(true) {
			Vector <Word> options = new Vector<Word>(4);
			int numbers[] = new int[4];
			int a;
			for(int i=0;i<4;i++) {
				a = r.nextInt(v.size());
				for(int j=0;j<4;j++) {
					if(a == numbers[j]&&i !=0)
						i--;
				}
				numbers[i] = a;
		}
			for(int i=0;i<4;i++) {
				options.add(v.get(numbers[i]));
			}
			int answerIndex = r.nextInt(4) +1;
			System.out.println(options.get(answerIndex-1).getEngWord() + "?");
				Iterator<Word> it = options.iterator();
				int k = 1;
				String separator = " ";
				while(it.hasNext()) {
					String option = it.next().getKorWord();
					if(it.hasNext() == false)
						separator = ">>";
					System.out.print("(" + k + " )" + option + separator);
					k += 1;
				}
				int user = sc.nextInt();
				if(user == -1) {
					System.out.println();
					break;
				}
					if(user == answerIndex)
						System.out.println("Excellent!!");
					else
						System.out.println("No.!!");
				}
			}
			public void finish() {
				System.out.println("\"명품언어\"를 종료합니다.");
				System.exit(0);
			}
}
   
	public class openchallenge {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			WordQuiz WordQuiz = new WordQuiz();
			
			while(true) {
				System.out.print("단어 테스트: 1,단어삽입: 2, 종료: 3 >>");
				int option = scanner.nextInt();
				
				switch(option) {
				case 1:
					WordQuiz.test();
					break;
				case 2:
					WordQuiz.insert();
					break;
				case 3:
					WordQuiz.finish();
					break;
				default:
					System.out.println("값을 잘못입력하셨습니다.");
				}
				scanner.close();
			}
		}
}
