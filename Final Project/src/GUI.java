/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: Simple JFrame UI to display season stats
 */

import Soccer.Season;
import Soccer.Team;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


/**
 * UI method to display the simulation stats
 */
public class GUI extends JFrame {

    /**
     * Constructor that will display the season results
     */
    public GUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();

        Season season = Season.getInstance();

        int numTeams = Season.getNumTeams();
        Team[] teams = new Team[(numTeams)];

        int i = 0;
        for (Team t : season.getTeams()) {
            teams[i] = t;
            i++;
        }

        JList<Team> teamJList = new JList<>(teams);

        p.setBorder(new EmptyBorder(20, 20, 20, 20)); // 20 px on left and right
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(new JLabel("After the season here are the results (W-D-L Points)"));
        p.add(teamJList);

        getContentPane().add(p);
        pack();
        setVisible(true);
        setMinimumSize(new Dimension(400, 400));
    }

}
