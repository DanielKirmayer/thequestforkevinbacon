import java.util.ArrayList;
import java.util.Objects;
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





        ArrayList<SimpleMovie> moviesWithActor = new ArrayList<SimpleMovie>();
        ArrayList<SimpleMovie> moviesWithActor2nd = new ArrayList<SimpleMovie>();
        ArrayList<String> actorsWithActor = new ArrayList<String>();
        ArrayList<String> twoActorDegreeActors = new ArrayList<String>();
        for (SimpleMovie movie : movies) {
            if(movie.getActors().contains(actorToSearch)) {
                moviesWithActor.add(movie);
                movie.setActorDegree(1);

            }

        }




        for (SimpleMovie simpleMovie : moviesWithActor) {
            actorsWithActor.addAll(simpleMovie.getActors());
        }

        for (SimpleMovie movie : movies) {
            for (String string : actorsWithActor) {
                if (movie.getActors().contains(string)) {
                    moviesWithActor2nd.add(movie);
                    movie.setActorDegree(2);

                }
            }

        }
        for (SimpleMovie simpleMovie : moviesWithActor2nd) {
            twoActorDegreeActors.addAll(simpleMovie.getActors());
        }



        boolean found = false;

        if (actorsWithBacon.contains(actorToSearch)) {
            System.out.println("One Bacon Degree");
            found = true;
        }
        if (twoBaconDegreeActors.contains(actorToSearch) && !found){
            System.out.println("Two Bacon Degrees");
            found = true;}


        if (!found) {
            for (int i = 0; i < actorsWithActor.size(); i++) {
                if(twoBaconDegreeActors.contains(actorsWithActor.get(i))){
                    found = true;
                    System.out.println("Three Bacon Degrees");
                    break;}
            }
        }

        if(!found){
            for (int i = 0; i < twoActorDegreeActors.size(); i++) {
                if(twoBaconDegreeActors.contains(twoActorDegreeActors.get(i))){
                    found = true;
                    System.out.println("Four Bacon Degrees");
                    break;}
            }
        }






        System.out.println("Number of movies: " + movies.size());
        System.out.println("Number of 2 degree movies: "+ moviesWithBacon2nd.size());
        System.out.println("Number of 2 degree actor movies: "+ moviesWithActor2nd.size());
        System.out.println("Number of 1 degree actors with actor "+ actorsWithActor.size());
        System.out.println("Number of 2 degree actors with actor "+ twoActorDegreeActors.size());
        System.out.println("Number of 2 degree actors with Bacon "+ twoBaconDegreeActors.size());
        System.out.println("Number of movies with Bacon: " + moviesWithBacon.size());
        System.out.println("Number of movies with Actor: "+ moviesWithActor.size());
    }
}