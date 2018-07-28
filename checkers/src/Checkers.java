
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Checkers  implements MouseListener , Cloneable{



    private char positionX;
    private int positionY;
   public char color;
    public java.lang.String name;
    public static String[] arStatCoord;
    public static char[] arStatColor;
    public int PosDel = -1;
    public int King = -1;
    public boolean dead = false;

    public Checkers(int posY, char posX){
        if (posX !='u') {
            positionX = posX;
            positionY = posY;


            //System.out.println(positionX);
            // System.out.println(positionY);
        }
    }

    public static void setArrStatCoord(String[] ar){
        arStatCoord = ar;
    }

    public static void setArStatColor(char[] arStatColor) {
        Checkers.arStatColor = arStatColor;
    }

    public void setPositionX(char positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public char getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public char getColor(){
        return color;
    }

    public int getPosKing(char x, int y){
        return -1;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean getDead(){
        return dead;
    }

    public java.lang.String getName() {
        setName();
        return name;
    }

    public void setName(){
        name = new StringBuilder().append(positionX).append(positionY).toString();
    }

        public boolean checkMuve(char X, int Y){
            return true;
        }

       public int[][] Capabilitie_kick() {
            int[][] d=new int[1][1];
            return d;
       }


    public Checkers clone() throws CloneNotSupportedException{

        return (Checkers) super.clone();
    }


    public int Muve( char X , int Y){
        if(checkMuve(X,Y)){
            setPositionY(Y);
            setPositionX(X);

            return PosDel;
        }
        return PosDel;
    }

    public void test(int t){
        //System.out.println(t);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();

        int y = e.getY();
        System.out.println(x);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
