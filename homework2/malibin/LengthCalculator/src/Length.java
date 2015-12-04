import java.util.Objects;

public class Length {

    private final int num;
    private final LengthType type;

    public Length(int num, LengthType type) {
        this.num = num;
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public LengthType getType() {
        return type;
    }

    public int getBaseNum() {
        return type.getBaseNum() * this.num;
    }

    @Override
    public boolean equals(Object obj) {
        Length length = (Length) obj;
        int num = length.getNum();
        LengthType type = length.getType();

        if(this.type == type) {
            return this.num == num;
        } else  {
            return this.getBaseNum() == length.getBaseNum();
        }
    }

}
