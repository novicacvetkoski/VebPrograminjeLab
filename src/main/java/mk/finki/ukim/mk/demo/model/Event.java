package mk.finki.ukim.mk.demo.model;

public class Event {
    private String name;
    private String description;
    private double popularityScore;

    private long id;
    private Location location;

    boolean liked;

    public boolean isLiked() {
        return liked;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPopularityScore() {
        return popularityScore;
    }
    public long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPopularityScore(double popularityScore) {
        this.popularityScore = popularityScore;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Event(String name, String description, double popularityScore) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.liked = true;
    }

    public void like(){
        this.popularityScore+=5;
        liked = false;
    }


}
