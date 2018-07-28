import java.util.Arrays;

public class II_muve_inf implements Cloneable{



    int [] ar_Ch_y = new int [34];
    char [] ar_Ch_x = new char [34];
    int II_e;
    int II_ee;
    char next_muve;
    boolean mast_two_kick;
    int two_kick_Numb;
    boolean success_choose;
    boolean success_muve;
    boolean II_correct_chuse;
    boolean mast_kick;
    boolean II_step_by_step_was_muve;
    boolean was_kick;
    boolean [] Dead = new boolean[34];
    int II_step_by_step_LOOP_FOR;







    public II_muve_inf clone() throws CloneNotSupportedException{

        return (II_muve_inf) super.clone();
    }


    public int get_next_II_step_by_step_LOOP_FOR() {
        return II_step_by_step_LOOP_FOR + 1;
    }

    public void setII_step_by_step_LOOP_FOR(int II_step_by_step_LOOP_FOR) {
        this.II_step_by_step_LOOP_FOR = II_step_by_step_LOOP_FOR;
    }

    public boolean[] getDead() {
        return Dead;
    }

    public void setDead(Checkers [] ar_Obj) {
        for (int i = 0; i < ar_Obj.length; i++) {
            Dead[i] = ar_Obj[i].getDead();
        }
    }

    public boolean getSuccess_muve() {
        return success_muve;
    }

    public void setSuccess_muve(boolean success_muve) {
        this.success_muve = success_muve;
    }

    public boolean getWas_kick() {
        return was_kick;
    }

    public void setWas_kick(boolean was_kick) {
        this.was_kick = was_kick;
    }

    public boolean getII_step_by_step_was_muve() {
        return II_step_by_step_was_muve;
    }

    public void setII_step_by_step_was_muve(boolean II_step_by_step_was_muve) {
        this.II_step_by_step_was_muve = II_step_by_step_was_muve;
    }

    public boolean getMast_kick() {
        return mast_kick;
    }

    public void setMast_kick(boolean mast_kick) {
        this.mast_kick = mast_kick;
    }

    public boolean getII_correct_chuse() {
        return II_correct_chuse;
    }

    public void setII_correct_chuse(boolean II_correct_chuse) {
        this.II_correct_chuse = II_correct_chuse;
    }

    public boolean getSuccess_choose() {
        return success_choose;
    }

    public void setSuccess_choose(boolean success_choose) {
        this.success_choose = success_choose;
    }

    public int getTwo_kick_Numb() {
        return two_kick_Numb;
    }


    public void setTwo_kick_Numb(int two_kick_Numb) {
        this.two_kick_Numb = two_kick_Numb;
    }

    public boolean getMast_two_kick() {
        return mast_two_kick;
    }

    public void setMast_two_kick(boolean mast_two_kick) {
        this.mast_two_kick = mast_two_kick;
    }




    public char getNext_muve() {
        return next_muve;
    }

    public void setNext_muve(char next_muve) {
        this.next_muve = next_muve;
    }


    public int[] getAr_Ch_y() {
        return ar_Ch_y;
    }

    public void setAr_Ch_y(Checkers [] ar_Obj) {
        for(int i =0; i<ar_Obj.length; i ++){
            ar_Ch_y[i] = ar_Obj[i].getPositionY();
        }
    }



    public char[] getAr_Ch_x() {
        return ar_Ch_x;
    }

    public void setAr_Ch_x(Checkers [] ar_Obj) {
        for(int i =0; i<ar_Obj.length; i ++){
            ar_Ch_x[i] = ar_Obj[i].getPositionX();
           }
    }



    public int getII_e() {
        return II_e;
    }

    public void setII_e(int II_e) {
        this.II_e = II_e;
    }



    public int getII_ee() {
        return II_ee;
    }

    public void setII_ee(int TT_ee) {
        this.II_ee = TT_ee;
    }
}
