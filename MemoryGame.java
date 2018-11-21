import java.util.*;

class MemoryGame {

  public static <T> void shuffle(T[] arr) {
    Random rand = new Random();
    for(int i = arr.length - 1; i > 0; i--) {
      int index = rand.nextInt(i + 1);
      swap(arr, i, index);
    }
  }

  public static <T> void swap(T[] arr, int x, int y) {
    T temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public static boolean checkPair(int[] chosenCard, Song[] songs) {
    return (songs[chosenCard[0]].imgName == songs[chosenCard[1]].imgName);
  }

  public static void main(String[] args){
    String[][] img_song_list = new String[][] {
      {"hallo.jpg", "hello.mp3"},
      {"hallo-2.jpg", "hello-2.mp3"},
      {"hallo-3.jpg", "hello-3.mp3"}
    };

    int matched = 0;
    int turn = 0;
    int[] chosenCard = new int[2];

    Song[] songs = new Song[img_song_list.length * 2];
    for(int i = 0; i < img_song_list.length; i++) {
      songs[i] = new Song(img_song_list[i][0], img_song_list[i][1]);
    }
    for(int i = 0; i < img_song_list.length; i++) {
      songs[i + 3] = new Song(img_song_list[i][0], img_song_list[i][1]);
    }

    shuffle(songs);

    for(Song s : songs) {
      System.out.println("image: " + s.imgName);
      System.out.println("name: " + s.songName);
    }

    while(matched < img_song_list.length) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Card " + (turn + 1) + ": ");
      chosenCard[turn] = sc.nextInt();
      turn++;
      if(turn == 2) {
        if(checkPair(chosenCard, songs)) {
          System.out.println("MATCHED!");
          matched++;
        }
        turn = 0;
      }
    }
  }

  private static class Song {
    private String imgName;
    private String songName;

    public Song(String imgName, String songName) {
      this.imgName = imgName;
      this.songName = songName;
    }
  }
}

// List<Integer> haha = new ArrayList<>();

// abstract class List<T> {
//   static final STARTING_LENGTH = 10;
//   private T[] actual_list = new T[STARTING_LENGTH];
//   private int length = 0;

//   // overloading functions
//   public List();
//   public List(int size) {
//     this.actual_list = new T[size];
//   }

//   public int getLength() {
//     return this.length;
//   }
// }

// class ArrayList<T> extends List<T> {
//   // override
//   @Override
//   public int getLength() {

//   }
// }
