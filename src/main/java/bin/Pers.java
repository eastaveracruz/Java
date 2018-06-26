package bin;

import java.io.Serializable;

public class Pers implements Serializable {
    private int level;
    private int life;
    private int mana;
    static private int month;

    public Pers(int level, int life, int mana, int month) {
        this.level = level;
        this.life = life;
        this.mana = mana;
    }

    @Override
    public String toString() {
        return "Pers{" +
                "level=" + level +
                ", life=" + life +
                ", mana=" + mana +
                '}';
    }
}
