package common;

import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 *
 * @author instlogin
 */
public class Movie implements Comparable<Movie> {
    private String title;
    private String director;

    public int compareTo(Movie o) {

       return new CompareToBuilder()
               .append(this.title, o.title)
               .append(this.director, o.director)
               .toComparison();


//        if(this.equals(o)) return 0;
//
//        int c = this.title.compareTo(o.title);
//        if(c != 0) {
//            return c;
//        } else {
//            c = this.director.compareTo(o.director);
//            return c;
//        }
     
    }
}
