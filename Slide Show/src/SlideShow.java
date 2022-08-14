import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JList;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(new Color(128, 255, 255));
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		/*logic to add each of the slides and text
		 * The use of a for loop gives the slide and 
		 * text area an assign number up to 5 
		 * Keeping the slides to 5 cards*/
		
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 * Treats each component in the container as a card
	 * Displaying both the card and the text
	 * Flipping to the previous card only displaying one at a time
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 * Treats each component in the container as a card
	 * Displaying both the card and the text 
	 * Flipping to the next card only displaying one at a time
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * This method is use to get the images form the resource folder
	 * to display to the specific slide  keeping all images 
	 * with the limits of 800 width and 500 height
	 * For our Top 5 Wellness Resorts 
	 */
	
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/CalaVie-California.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Lake_Austin_Spa.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/The_Ranch.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Red_Mountain_Utah2.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Canyon_Ranch_Lenox.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 * This method will display the 
	 * Name and location of each resort 
	 * using a bolder font size of 5 while
	 * also displaying a description of each location
	 * using a smaller normal font size 
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 Cal-a-Vie Health Spa: Vista California </font> <br>North Of San Diego There is a number of Spa treatments to help you relax in this European-style hideway </body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Lake Austin Spa Resort: Austin Texas </font> <br>This intimate retreat boasts a lakefront locale with a lavish detox spa </body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 The Ranch: Malibu California </font> <br>Fitness classes and hikes combined with a specialized meal plan will help your rejuvenation process unfold </body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 Red Mountain Resort: Ivans Utah </font> <br>An adventurous detox vacation with activities like hiking and kayaking </body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Canyon Ranch: Lenox Massachusetts </font> <br>Exercise therapists,energy healers and spiritual counselors help you unearth your inner peace</body></html>";
		}
		return text;
	}

			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}