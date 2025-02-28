import java.util.ArrayList;

public class SimpleMovie {


    private String title;
    private String actorsData;
    private ArrayList<String> actors;
    private int baconDegree = 0;
    private int actorDegree = 0;

    public SimpleMovie(String t, String a) {
        title = t;
        actorsData = a;
        actors = new ArrayList<String>();
        String[] tempActors = actorsData.split(":");
        for (int i = 0; i < tempActors.length; i++) {
            actors.add(tempActors[i]);
        }

    }

    public ArrayList<String> getActors(){
        return actors;
    }

    public void removeActors(ArrayList<String> removalList){
        actors.removeAll(removalList);
    }
    public void setBaconDegree(int x){
        baconDegree = x;
    }
    public void setActorDegree(int x){
        actorDegree = x;
    }

    public int getBaconDegree() {
        return baconDegree;
    }

    public int getActorDegree() {
        return actorDegree;
    }

    public String getTitle() {
        return title;
    }
    public String toString() {
        return "Title: " + title + "\n" + "Actors: " + actors + "\n";
    }

}