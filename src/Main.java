import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter a name to search for bacon degree! ");

        Scanner s = new Scanner(System.in);

        String actorToSearch = s.nextLine();

        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");
        ArrayList<SimpleMovie> moviesWithBacon = new ArrayList<SimpleMovie>();
        ArrayList<SimpleMovie> moviesWithBacon2nd = new ArrayList<SimpleMovie>();
        ArrayList<String> actorsWithBacon = new ArrayList<String>();
        ArrayList<String> twoBaconDegreeActors = new ArrayList<String>();
        for (SimpleMovie movie : movies) {
            if(movie.getActors().contains("Kevin Bacon")) {
                moviesWithBacon.add(movie);
                movie.setBaconDegree(1);

            }

        }




        for (SimpleMovie simpleMovie : moviesWithBacon) {
            actorsWithBacon.addAll(simpleMovie.getActors());
        }
        if (actorsWithBacon.contains(actorToSearch))
            System.out.println("One Bacon Degree");

        for (SimpleMovie movie : movies) {
            for (String string : actorsWithBacon) {
                if (movie.getActors().contains(string)) {
                    moviesWithBacon2nd.add(movie);
                    movie.setBaconDegree(2);

                }
            }

        }
        for (SimpleMovie simpleMovie : moviesWithBacon2nd) {
            twoBaconDegreeActors.addAll(simpleMovie.getActors());
        }

        if (twoBaconDegreeActors.contains(actorToSearch))
            System.out.println("Two Bacon Degrees");

        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getBaconDegree() == 1)
                movies.get(i).removeActors(actorsWithBacon);

        }






        System.out.println("Number of movies: " + movies.size());
        System.out.println("Number of 2 degree movies: "+ moviesWithBacon2nd.size());
        System.out.println("Number of movies with Bacon: " + moviesWithBacon.size());
    }
}