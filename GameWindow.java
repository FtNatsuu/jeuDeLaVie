import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindow extends JFrame {

    private int largeurRectangle0, largeurRectangle1, largeurRectangle2, largeurRectangle3, largeurRectangle4, largeurRectangle5, largeurRectangle6;
    private int hauteurRectangle0, hauteurRectangle1, hauteurRectangle2, hauteurRectangle3, hauteurRectangle4, hauteurRectangle5, hauteurRectangle6;
    private int yRectangle0, yRectangle1, yRectangle2, yRectangle3, yRectangle4, yRectangle5, yRectangle6;
    private int xRectangle2, xRectangle3, xRectangle4, xRectangle5, xRectangle6;
    private Rectangle rectangle0, rectangle1, rectangle2, rectangle3, rectangle4, rectangle5, rectangle6, bouton_quitter;
    // Constructeur
    public GameWindow() {
        // Configuration de la fenêtre en plein écran
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true); // Supprime les bordures de la fenêtre

        // Ajout du JPanel personnalisé à la fenêtre
        add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                int largeurFenetre = getWidth();
                int hauteurFenetre = getHeight();

                // Calcul des dimensions et positions des rectangles

                largeurRectangle0 = largeurFenetre;
                hauteurRectangle0 = hauteurFenetre;
                yRectangle0 = (int) 0;

                largeurRectangle1 = largeurFenetre;
                hauteurRectangle1 = (int) (hauteurFenetre * 0.9);
                yRectangle1 = (int) (hauteurFenetre * 0.08);

                largeurRectangle2 = (int) (largeurFenetre * 0.7);
                hauteurRectangle2 = (int) (hauteurFenetre * 0.85);
                int delta = (int) (hauteurRectangle1 - hauteurRectangle2) / 2;
                xRectangle2 = (int) (delta);
                yRectangle2 = (int) (yRectangle1 + delta);

                largeurRectangle3 = (int) (largeurFenetre - 3 * delta - largeurRectangle2);
                hauteurRectangle3 = hauteurRectangle2;
                xRectangle3 = xRectangle2 + largeurRectangle2 + delta;
                yRectangle3 = yRectangle2;

                largeurRectangle4 = (int) (largeurRectangle3 - 2 * delta);
                hauteurRectangle4 = (int) (hauteurRectangle3 * 0.12);
                xRectangle4 = (int) (xRectangle3 + delta);
                yRectangle4 = (int) (yRectangle3 + delta);

                largeurRectangle5 = (int) (largeurRectangle4 - delta) / 2;
                hauteurRectangle5 = (int) (hauteurRectangle4);
                xRectangle5 = (int) (xRectangle4);
                yRectangle5 = (int) (yRectangle3 + hauteurRectangle3 - hauteurRectangle4 - delta);

                largeurRectangle6 = (int) (largeurRectangle4);
                hauteurRectangle6 = (int) (hauteurRectangle3 - 5 * delta - 3 * hauteurRectangle4);
                xRectangle6 = (int) (xRectangle4);
                yRectangle6 = (int) (yRectangle3 + 3 * delta + 2 * hauteurRectangle4);

                // Dessin du background rectangle
                g2d.setColor(new Color(0x383A40));
                g2d.fillRect(0, yRectangle0, largeurRectangle0, hauteurRectangle0);

                // Dessin du 1er rectangle
                g2d.setColor(new Color(0x313338));
                g2d.fillRect(0, yRectangle1, largeurRectangle1, hauteurRectangle1);

                // Dessin du 2eme rectangle
                g2d.setColor(new Color(0x5BD952));
                g2d.fillRect(xRectangle2, yRectangle2, largeurRectangle2, hauteurRectangle2);

                // Dessin du 3eme rectangle
                g2d.setColor(new Color(0x2B2D31));
                g2d.fillRect(xRectangle3, yRectangle3, largeurRectangle3, hauteurRectangle3);

                // Dessin du 4eme rectangle
                g2d.setColor(new Color(0x242528));
                g2d.fillRect(xRectangle4, yRectangle4, largeurRectangle4, hauteurRectangle4);

                // Dessin du 4eme bis rectangle
                g2d.setColor(new Color(0x242528));
                g2d.fillRect(xRectangle4, yRectangle4 + hauteurRectangle4 + delta, largeurRectangle4, hauteurRectangle4);

                // Dessin du 5eme rectangle
                g2d.setColor(new Color(0x242528));
                g2d.fillRect(xRectangle5, yRectangle5, largeurRectangle5, hauteurRectangle5);

                // Dessin du 5eme bis rectangle
                g2d.setColor(new Color(0xE2654F));
                g2d.fillRect(xRectangle5 + largeurRectangle5 + delta, yRectangle5, largeurRectangle5, hauteurRectangle5);

                // Dessin du 6eme rectangle
                g2d.setColor(new Color(0x242528));
                g2d.fillRect(xRectangle6, yRectangle6, largeurRectangle6, hauteurRectangle6);
                rectangle6 = new Rectangle(xRectangle6, yRectangle6, largeurRectangle6, hauteurRectangle6);

                // Dessin de la croix rouge pour fermer la fenêtre
                g2d.setColor(new Color(0xE2654F));
                int tailleCroix = 20; // Taille de la croix
                int demiEpaisseur = 6; // Demi-épaisseur de la croix
                int yCenter = yRectangle1 / 2; // Centre vertical de la croix

                // Définition de l'épaisseur de la ligne et des extrémités carrées
                g2d.setStroke(new BasicStroke(demiEpaisseur * 2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));

                // Dessin de la croix inclinée
                g2d.drawLine(largeurFenetre - tailleCroix - delta, yCenter - tailleCroix / 2, largeurFenetre - delta, yCenter + tailleCroix / 2);
                g2d.drawLine(largeurFenetre - tailleCroix - delta, yCenter + tailleCroix / 2, largeurFenetre - delta, yCenter - tailleCroix / 2);
                bouton_quitter = new Rectangle(largeurFenetre-tailleCroix-delta, yCenter - tailleCroix / 2, tailleCroix, tailleCroix);




                // Ajout du texte "jeu de la vie"

                Font font1 = new Font("Impact", Font.PLAIN, 40);
                Font font2 = new Font("Impact", Font.PLAIN, 30);
                g2d.setColor(new Color(0xDDC300));

                String texte1 = "Jeu de la vie";
                String texte2 = "Staying alive rules";
                String texte3 = "Born rules";
                String texte4 = "Statistiques";
                String texte5 = "Restart";
                String texte6 = "STOP";

                // Titre
                g2d.setFont(font1);
                FontMetrics fm1 = g2d.getFontMetrics();
                int hauteurTexte1 = fm1.getHeight();
                int xTexte1 = delta;
                int yTexte1 = (yRectangle1 - hauteurTexte1) / 2 + fm1.getAscent();
                g2d.drawString(texte1, xTexte1, yTexte1);

                // Rules + Stats + Restart + Stop
                g2d.setFont(font2);
                FontMetrics fm2 = g2d.getFontMetrics();
                int xTexte2 = xRectangle4 + delta / 2;
                int yTexte2 = yRectangle4 + fm2.getAscent();
                int yTexte3 = yTexte2 + hauteurRectangle4 + delta;
                int yTexte4 = yTexte3 + hauteurRectangle4 + delta;
                int xTexte5 = xRectangle4 + (largeurRectangle5 - fm2.stringWidth(texte5)) / 2;
                int yTexte5 = yTexte4 + hauteurRectangle6 + delta + (hauteurRectangle5 - fm2.getHeight()) / 2;
                int xTexte6 = delta + largeurRectangle5 + xRectangle4 + (largeurRectangle5 - fm2.stringWidth(texte6)) / 2;
                g2d.drawString(texte2, xTexte2, yTexte2);
                g2d.drawString(texte3, xTexte2, yTexte3);
                g2d.drawString(texte4, xTexte2, yTexte4);
                g2d.drawString(texte5, xTexte5, yTexte5);
                g2d.setColor(new Color(0xE0DAD7));
                g2d.drawString(texte6, xTexte6, yTexte5);
            }
        });

        // Ajout de l'écouteur de clic pour fermer la fenêtre
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (bouton_quitter.contains(e.getPoint())) {
                    // Fermer la fenêtre
                    dispose();
                }
            }
        });
    }

    // Méthode principale
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameWindow fenetre = new GameWindow();
            fenetre.setVisible(true); // Rendre la fenêtre visible
        });
    }
}
