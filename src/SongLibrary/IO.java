/* 
 * 
 * 02/15
 * Joseph Pestonit
 * 
 */

package SongLibrary;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class IO extends JPanel{
	public JButton add,delete,edit;
	public JTextArea display,error;
	public IO(final LibView l){
		
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill=GridBagConstraints.BOTH;
		c.gridheight=1;
		c.gridwidth=1;
		c.weightx=1;
		c.weighty=1;
		add = new JButton("Add");
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				l.addSong();
				l.updateDisplay();
			}
		});
		gridbag.setConstraints(add, c);
		add(add);
		
		edit = new JButton("Edit");
		edit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				l.editSong();
				l.updateDisplay();
			}
		});
		gridbag.setConstraints(edit, c);
		add(edit);
		
		c.gridwidth = GridBagConstraints.REMAINDER;
		delete = new JButton("Delete");
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				l.deleteSong();
				l.updateDisplay();
			}
		});

		gridbag.setConstraints(delete, c);
		
		add(delete);
		
		
		display = new JTextArea("No song selected.");
		display.setLineWrap(true);
		display.setWrapStyleWord(true);
		display.setAlignmentY(CENTER_ALIGNMENT);
		gridbag.setConstraints(display, c);
		add(display);
		
		error = new JTextArea("Input fields and click add to add. Select song in list and input fields and click edit to edit. Select song in list and delete to delete.");
		error.setLineWrap(true);
		error.setWrapStyleWord(true);
		error.setAlignmentY(CENTER_ALIGNMENT);
		gridbag.setConstraints(error, c);
		add(error);
		
	}
	
	
}
