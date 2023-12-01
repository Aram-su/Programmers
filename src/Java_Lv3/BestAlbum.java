package Java_Lv3;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {

        BestAlbum bestAlbum = new BestAlbum();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(bestAlbum.solution(genres, plays)));
    }

    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> albumNumbers = new ArrayList<>();
        ArrayList<Integer> sortedPlays = new ArrayList<>();
        HashMap<String, Integer> genreToPlay = new HashMap<>();
        HashMap<Integer, String> playToGenre = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (genreToPlay.containsKey(genres[i])) {
                genreToPlay.put(genres[i], genreToPlay.get(genres[i]) + plays[i]);
            } else {
                genreToPlay.put(genres[i], plays[i]);
            }
        }
        for (String genre : genreToPlay.keySet()) {
            playToGenre.put(genreToPlay.get(genre), genre);
            sortedPlays.add(genreToPlay.get(genre));
        }
        sortedPlays.sort(Collections.reverseOrder());


        for (Integer play : sortedPlays) {
            String genre = playToGenre.get(play);

            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if( o2[0] != o1[0]) return o2[0] - o1[0];
                    return o1[1] - o2[1];
                }
            });

            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i])) {
                    pq.add(new int[]{plays[i], i});
                }
            }


            if (pq.size() == 1) {
                albumNumbers.add(pq.poll()[1]);
            } else if ( pq.size() >= 2){
                albumNumbers.add(pq.poll()[1]);
                albumNumbers.add(pq.poll()[1]);
            }
        }
        int[] answer = new int[albumNumbers.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = albumNumbers.get(i);
        }
        return answer;
    }
}
