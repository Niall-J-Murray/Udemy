import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {

	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {

		LinkedList<Song> playlist = new LinkedList<>();

		// Consider making method to copy and paste track listings, then insert the
		// correct parameters into album.addSong();
		Album album = new Album("Enter the Wu-Tang (36 Chambers)", "Wu-Tang Clan");
		album.addSong("Bring da Ruckus", 4, 10);
		album.addSong("Shame on a Nigga", 2, 57);
		album.addSong("Clan in da Front", 4, 33);
		album.addSong("Wu-Tang: 7th Chamber", 6, 05);
		album.addSong("Can It Be All So Simple", 4, 46);
		album.addSong("Protect Ya Neck", 6, 48);
		album.addSong("Da Mystery of Chessboxin'", 4, 48);
		album.addSong("Wu-Tang Clan Ain't Nuthing ta Fuck Wit", 3, 36);
		album.addSong("C.R.E.A.M.", 4, 12);
		album.addSong("Method Man", 5, 50);
		album.addSong("Tearz", 4, 17);
		album.addSong("Wu-Tang: 7th Chamber – Part II", 5, 8);
		album.addSong("Conclusion", 1, 02);
		albums.add(album);

		album = new Album("Run the Jewels", "Run the Jewels");
		album.addSong("Run the Jewels", 3, 30);
		album.addSong("Banana Clipper", 2, 51);
		album.addSong("36\"Chain", 2, 52);
		album.addSong("DDFH", 3, 5);
		album.addSong("Sea Legs", 3, 40);
		album.addSong("Job Well Done", 2, 59);
		album.addSong("No Come Down", 3, 28);
		album.addSong("Get It", 3, 0);
		album.addSong("Twin Hype Back", 3, 12);
		album.addSong("A Christmas Fucking Miracle", 4, 21);
		albums.add(album);

		albums.get(0).addToPlaylist("Protect Ya Neck", playlist);
		albums.get(0).addToPlaylist("Method Man", playlist);
		albums.get(0).addToPlaylist("Da Mystery of Chessboxin'", playlist);
		albums.get(0).addToPlaylist("The Triumph", playlist); // Not on album.
		albums.get(0).addToPlaylist(1, playlist);
		albums.get(1).addToPlaylist("Run the Jewels", playlist);
		albums.get(1).addToPlaylist(4, playlist);
		albums.get(1).addToPlaylist(7, playlist);
		albums.get(1).addToPlaylist(12, playlist); // Not on album.

		play(playlist);

	}

	private static void play(LinkedList<Song> playlist) {
		try (Scanner scanner = new Scanner(System.in)) {
			boolean quit = false;
			boolean forward = true;
			ListIterator<Song> listIterator = playlist.listIterator();
			if (playlist.size() == 0) {
				System.out.println("Playlist is empty!");
			} else {
				// Add artist to now playing.
				System.out.println("Now playing: " + listIterator.next().toString());
			}

			printMenu();
			while (!quit) {
				int action = scanner.nextInt();
				scanner.nextLine();

				switch (action) {
				case 0:
					System.out.println("Ending playlist...");
					quit = true;
					break;
				case 1:
					if (!forward) {
						if (listIterator.hasNext()) {
							listIterator.next();
						}
						forward = true;
					}
					if (listIterator.hasNext()) {
						System.out.println("Now playing: " + listIterator.next());
					} else {
						System.out.println("End of playlist.");
						forward = false;
					}
					break;
				case 2:
					if (forward) {
						if (listIterator.hasPrevious()) {
							listIterator.previous();
						}
						forward = false;
					}
					if (listIterator.hasPrevious()) {
						System.out.println("Now playing: " + listIterator.previous());
					} else {
						System.out.println("Start of playlist");
						forward = true;
					}
					break;
				case 3:
					if (forward) {
						if (listIterator.hasPrevious()) {
							System.out.println("Now playing: " + listIterator.previous());
							forward = false;
						} else {
							System.out.println("Start of playlist: ");
						}
					} else {
						if (listIterator.hasNext()) {
							System.out.println("Now playing: " + listIterator.next());
							forward = true;
						} else {
							System.out.println("End of playlist");
						}
					}
					break;
				case 4:
					if (playlist.size() > 0) {
						listIterator.remove();
						if (listIterator.hasNext()) {
							System.out.println("Now playing: " + listIterator.next());
						} else if (listIterator.hasPrevious()) {
							System.out.println("Now playing: " + listIterator.previous());
						}
					}
					break;
				case 5:
					printList(playlist);
					break;
				case 6:
					printMenu();
					break;

				default:
					System.out.println("Invalid selection!");
					System.out.println("Enter number from 0 to 5 only.");
					System.out.println("Press 5 to see options.");
				}
			}
		}

	}

	private static void printMenu() {

		System.out.println("""
				0 - Quit
				1 - Next Song
				2 - Previous Song
				3 - Replay Current Song
				4 - Delete Current Song
				5 - Show Playlist
				6 - Show Options
				Select an option from above:
				""");
	}

	private static void printList(LinkedList<Song> playlist) {
		Iterator<Song> iterator = playlist.iterator();
		System.out.println("Current Playlist:");
		System.out.println("========================");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("========================");
	}

}
