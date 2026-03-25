abstract class Media {
	private String title;
	private int duration;
	protected boolean isPremium;

	Media(String title, int duration, boolean isPremium) {
		this.title = title;
		this.duration = duration;
		this.isPremium = isPremium;
	}

	public String getTitle() {
		return title;
	}

	public int getDuration() {
		return duration;
	}

	public String getDetails() {
		return "Title: " + title + ", Duration: " + duration + " mins, Premium: " + isPremium;
	}

	abstract void playContent();
}

class Movie extends Media {
	Movie(String title, int duration, boolean isPremium) {
		super(title, duration, isPremium);
	}

	@Override
	void playContent() {
		if (isPremium) {
			System.out.print("Verifying Subscription... ");
		}
		System.out.println("Streaming Movie: " + getTitle());
	}
}

class Podcast extends Media {
	Podcast(String title, int duration) {
		super(title, duration, false);
	}

	@Override
	void playContent() {
		System.out.print("Loading Advertisement... ");
		System.out.println("Playing Podcast: " + getTitle());
	}
}

class streaming {
	public static void main(String[] args) {
		Media[] mediaList = {
			new Movie("Inception", 148, true),
			new Podcast("Tech Talk", 30),
			new Movie("Free Guy", 115, false)
		};

		for (Media media : mediaList) {
			media.playContent();
		}
	}
}
