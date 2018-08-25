/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.*;

public class Main {
	public enum Weather {
		COLD,
		WARM,
		RAIN
	}

	public static interface Notifyable {
		public void notify(Weather weather);
	}

    public static abstract class Entity implements Notifyable {
    	protected String name;
    	public void setName(String name) {
    		this.name = name;
    	}
    	protected String f(String pattern, String args) {
    		return String.format(pattern, args);
    	}
	}
    
    public static class Orc extends Entity {
    	public void notify(Weather weather) {
    		if (weather == Weather.COLD) {
    			System.out.println(f("%s: Cold weather is good for orcs!! kaef", name));
    		} else if (weather == Weather.WARM) {
    			System.out.println(f("%s: vawe niochem, ppc zharko (", name));
    		} else {
    			System.out.println(f("%s: na rain vawe pofig orcam", name));
    		}
    	}
    }

    public static class Hobbit extends Entity {
    	public void notify(Weather w) {
    		if (w == Weather.COLD) {
    			System.out.println(f("%s: Hobbitu holodno, hobbit hochet domoi", name));
    		} else if (w == Weather.WARM) {
    			System.out.println(f("%s: Hobbitu horowo, mozhno naulice poigrat'", name));
    		} else {
    			System.out.println(f("%s: kruto dozhdi, kaefx2", name));
    		}
    	}
    }

    public static class Nature {
    	private static Nature instance = null;
    	
    	private List<Notifyable> subscribers;
    	
    	public static Nature getInstance() {
    		if (instance == null) instance = new Nature();
    		return instance;
    	}

    	private Nature() {
    		subscribers = new ArrayList<>();
    	}
    	
    	public void changeWeather(Weather given) {
			subscribers.forEach(n -> n.notify(given));
    	}

    	public void subscribe(Notifyable notifyable) {
    		subscribers.add(notifyable);
    	}
    }

	public static void main(String[] args) {
		final Nature nature = Nature.getInstance();
		
		Weather weather = Weather.RAIN;
		
		Entity abylay = new Orc();
		Entity arystan = new Hobbit();
		abylay.setName("arystan");
		arystan.setName("abylay");
		
		nature.subscribe(abylay);
		nature.subscribe(arystan);

		List<Weather> weathers = Arrays.asList(Weather.COLD, Weather.WARM, Weather.RAIN);

		while (true) {
			for (Weather w : weathers) {
				try {
					Thread.sleep(3000);
				} catch (Exception e) {}
				nature.changeWeather(w);
			}
		}
	}
}
