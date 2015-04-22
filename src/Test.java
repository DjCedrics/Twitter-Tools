import java.util.List;

import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Test {
		public static void main(String[] args) throws TwitterException {
		    Twitter twitter = TwitterFactory.getSingleton();
		    List<Status> statuses = twitter.getFavorites();
		    twitter.createFriendship("caysiirmektup");
		    System.out.println("Showing home timeline.");
		    for ( Status s : statuses )
		    {
		    	System.out.println( s );
		    }
		    
		}
}
