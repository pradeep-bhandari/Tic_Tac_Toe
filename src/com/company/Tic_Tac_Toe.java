package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
public class Tic_Tac_Toe implements ActionListener
{
    Random random=new Random();
    JFrame frame=new JFrame();
    JLabel title=new JLabel();
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JButton[] Buttons=new JButton[9];
    boolean playerturn;
    Tic_Tac_Toe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        title.setText("Tic Tac Toe");
        title.setFont(new Font("Ink Free",Font.BOLD,70));
        title.setForeground(Color.green);
        title.setOpaque(false);

        button_panel.setLayout(new GridLayout(3,3));
        for(int i=0;i<9;i++)
        {
            Buttons[i]=new JButton();
            Buttons[i].setFocusable(false);
            Buttons[i].setForeground(Color.gray);
            button_panel.add(Buttons[i]);
            Buttons[i].addActionListener(this);
        }

        title_panel.setBackground(Color.BLACK);
        title_panel.add(title);
        frame.add(button_panel);
        frame.add(title_panel,BorderLayout.NORTH);
        Player();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<9;i++)
        {
            if(e.getSource()==Buttons[i])
            {
                if(playerturn)
                {
                    if(Buttons[i].getText().equals(""))
                    {
                       Buttons[i].setText("X");
                       Buttons[i].setForeground(Color.red);
                       Buttons[i].setFont(new Font("Ink Free",Font.BOLD,120));
                       title.setText("O Turn");
                       playerturn=false;
                       CheckWins();
                    }
                }
                else
                {
                    if(Buttons[i].getText().equals(""))
                    {
                        Buttons[i].setText("O");
                        Buttons[i].setForeground(Color.blue);
                        Buttons[i].setFont(new Font("Ink Free",Font.BOLD,120));
                        title.setText("X Turn");
                        playerturn=true;
                        CheckWins();
                    }
                }
            }
        }
    }
    public void Player()
    {
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt()==0)
        {
            playerturn=true;
            title.setText("X Turn");
        }
        else
        {
            playerturn=false;
            title.setText("O Turn");
        }

    }
    public void CheckWins()
    {
      if((Buttons)[0].getText().equals("X")&&(Buttons)[1].getText().equals("X")&&(Buttons)[2].getText().equals("X"))
        {
            Xwins(0,1,2);
        }
      if((Buttons)[4].getText().equals("X")&&(Buttons)[5].getText().equals("X")&&(Buttons)[6].getText().equals("X"))
        {
            Xwins(4,5,6);
        }

        if((Buttons)[0].getText().equals("X")&&(Buttons)[3].getText().equals("X")&&(Buttons)[6].getText().equals("X"))
        {
            Xwins(0,3,6);
        }
        if((Buttons)[1].getText().equals("X")&&(Buttons)[4].getText().equals("X")&&(Buttons)[7].getText().equals("X"))
        {
            Xwins(1,4,7);
        }
        if((Buttons)[2].getText().equals("X")&&(Buttons)[5].getText().equals("X")&&(Buttons)[8].getText().equals("X"))
        {
            Xwins(3,5,8);
        }
        if((Buttons)[0].getText().equals("X")&&(Buttons)[4].getText().equals("X")&&(Buttons)[8].getText().equals("X"))
        {
            Xwins(0,4,8);
        }
        if((Buttons)[2].getText().equals("X")&&(Buttons)[4].getText().equals("X")&&(Buttons)[6].getText().equals("X"))
        {
            Xwins(2,4,6);
        }
        if((Buttons)[0].getText().equals("O")&&(Buttons)[1].getText().equals("O")&&(Buttons)[2].getText().equals("O"))
        {
            Owins(0,1,2);
        }
        if((Buttons)[4].getText().equals("O")&&(Buttons)[5].getText().equals("O")&&(Buttons)[6].getText().equals("O"))
        {
            Owins(4,5,6);
        }

        if((Buttons)[0].getText().equals("O")&&(Buttons)[3].getText().equals("O")&&(Buttons)[6].getText().equals("O"))
        {
            Owins(0,3,6);
        }
        if((Buttons)[1].getText().equals("O")&&(Buttons)[4].getText().equals("O")&&(Buttons)[7].getText().equals("O"))
        {
            Owins(1,4,7);
        }
        if((Buttons)[2].getText().equals("O")&&(Buttons)[5].getText().equals("O")&&(Buttons)[8].getText().equals("O"))
        {
            Owins(3,5,8);
        }
        if((Buttons)[0].getText().equals("O")&&(Buttons)[4].getText().equals("O")&&(Buttons)[8].getText().equals("O"))
        {
            Owins(0,4,8);
        }
        if((Buttons)[2].getText().equals("O")&&(Buttons)[4].getText().equals("O")&&(Buttons)[6].getText().equals("O"))
        {
            Owins(2,4,6);
        }

    }
    public void Xwins(int a,int b,int c)
    {
       Buttons[a].setForeground(Color.green);
       Buttons[b].setForeground(Color.green);
       Buttons[c].setForeground(Color.green);
       JOptionPane.showMessageDialog(null,"X Wins the Match","Result",JOptionPane.INFORMATION_MESSAGE);
       for(int i=0;i<9;i++)
       {
           Buttons[i].setEnabled(false);
       }

    }
    public void Owins(int a,int b,int c)
    {
        Buttons[a].setForeground(Color.green);
        Buttons[b].setForeground(Color.green);
        Buttons[c].setForeground(Color.green);
        JOptionPane.showMessageDialog(null,"Y Wins the Match","Result",JOptionPane.INFORMATION_MESSAGE);
        for(int i=0;i<9;i++)
        {
            Buttons[i].setEnabled(false);
        }
    }

}
