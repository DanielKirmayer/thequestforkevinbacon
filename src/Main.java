import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String chain = "";
        SimpleMovie important = null;
        SimpleMovie important2 = null;
        SimpleMovie important3 = null;
        SimpleMovie important4 = null;
        String importantActor = "";
        String importantActor2 = "";
        String importantActor3 = "";

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

            for (int i = 0; i < moviesWithBacon.size(); i++) {
                if (moviesWithBacon.get(i).getActors().contains(actorToSearch))
                    chain = "Kevin Bacon ---> "+ moviesWithBacon.get(i).getTitle() + " ---> "+actorToSearch;

            }

            System.out.println("One Bacon Degree");
            System.out.println(chain);
            found = true;
        }
        if (twoBaconDegreeActors.contains(actorToSearch) && !found){

            for (int i = 0; i < moviesWithBacon2nd.size(); i++) {
                if(moviesWithBacon2nd.get(i).getActors().contains(actorToSearch)) {

                    important = moviesWithBacon2nd.get(i);
                    chain = moviesWithBacon2nd.get(i).getTitle() + " ---> " + actorToSearch;

                }


            }

            for (int i = 0; i < important.getActors().size(); i++) {
                for (int j = 0; j < moviesWithBacon.size(); j++) {
                    if (moviesWithBacon.get(j).getActors().contains(important.getActors().get(i))) {
                        important2 = moviesWithBacon.get(j);
                        importantActor = important.getActors().get(i);
                    }
                }
            }

            chain = "Kevin Bacon ---> "+ important2.getTitle() + " ---> "+importantActor+" ---> "+chain;


            System.out.println("Two Bacon Degrees");
            System.out.println(chain);


            found = true;}


        if (!found) {
            for (int i = 0; i < actorsWithActor.size(); i++) {
                if (twoBaconDegreeActors.contains(actorsWithActor.get(i))) {
                    importantActor = actorsWithActor.get(i);


                    found = true;
                    System.out.println("Three Bacon Degrees");
                    break;
                }
            }

            if (found) {
                for (int i = 0; i < moviesWithActor.size(); i++) {
                    if (moviesWithActor.get(i).getActors().contains(importantActor))
                        important = moviesWithActor.get(i);

                }
                for (int i = 0; i < moviesWithBacon2nd.size(); i++) {
                    if (moviesWithBacon2nd.get(i).getActors().contains(importantActor))
                        important2 = moviesWithBacon2nd.get(i);
                }

                for (int i = 0; i < actorsWithBacon.size(); i++) {
                    if (important2.getActors().contains(actorsWithBacon.get(i)))
                        importantActor2 = actorsWithBacon.get(i);


                }

                for (int i = 0; i < moviesWithBacon.size(); i++) {
                    if (moviesWithBacon.get(i).getActors().contains(importantActor2))
                        important3 = moviesWithBacon.get(i);

                }
                System.out.println("Kevin Bacon ---> " + important3.getTitle() + " ---> " + importantActor2 + " ---> " + important2.getTitle() + " ---> " + importantActor + " ---> " + important.getTitle() + " ---> " + actorToSearch);
            }
        }

        if(!found){
            for (int i = 0; i < twoActorDegreeActors.size(); i++) {
                if(twoBaconDegreeActors.contains(twoActorDegreeActors.get(i))){

                    importantActor2 = twoActorDegreeActors.get(i);

                    found = true;
                    System.out.println("Four Bacon Degrees");
                    break;}
            }

            for (int i = 0; i < moviesWithActor2nd.size(); i++) {
                if (moviesWithActor2nd.get(i).getActors().contains(importantActor2))
                    important2 = moviesWithActor2nd.get(i);
            }

            for (int i = 0; i < actorsWithActor.size(); i++) {
                if (important2.getActors().contains(actorsWithActor.get(i)))
                    importantActor = actorsWithActor.get(i);
            }

            for (int i = 0; i < moviesWithActor.size(); i++) {
                if(moviesWithActor.get(i).getActors().contains(importantActor))
                    important = moviesWithActor.get(i);
            }
            for (int i = 0; i < moviesWithBacon2nd.size(); i++) {
                if(moviesWithBacon2nd.get(i).getActors().contains(importantActor2))
                    important3 = moviesWithBacon2nd.get(i);
            }
            for (int i = 0; i < actorsWithBacon.size(); i++) {
                if(important3.getActors().contains(actorsWithBacon.get(i)))
                    importantActor3 = actorsWithBacon.get(i);
            }
            for (int i = 0; i < moviesWithBacon.size(); i++) {
                if(moviesWithBacon.get(i).getActors().contains(importantActor3))
                    important4 = moviesWithBacon.get(i);
            }
            System.out.println("Kevin Bacon ---> "+important4.getTitle()+" ---> "+importantActor3+" ---> "+important3.getTitle()+" ---> "+importantActor2 + " ---> "+ important2.getTitle() + " ---> "+ importantActor + " ---> "+ important.getTitle() + " ---> "+ actorToSearch);

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