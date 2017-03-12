/**
 * Created by qwerty on 12-Mar-17.
 */
public enum StudentType {
    Stationary{
        @Override public String toString(){
            return "Stationary";
        }
    },
    Nonstationary{
        @Override public String toString(){
            return "Nonstationary";
        }
    },
    Postgraduate{
        @Override public String toString()
        {
            return "Postgraduate";
        }
    }
}
