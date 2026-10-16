import java.util.*;

class complex {
    int real, img;

    public complex(int r, int i) {
        this.real = r;
        this.img = i;
    }

    public complex add(complex other) {
        return new complex(real + other.real, img + other.img);
    }

    public complex multi(complex other) {
        return new complex(
            real * other.real - img * other.img,
            real * other.img + img * other.real
        );
    }

    public String toString() {
        if (img > 0) return real + " + " + img + "i";
        return real + " - " + Math.abs(img) + "i";
    }
}

public class sophuc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            complex a = new complex(sc.nextInt(), sc.nextInt());
            complex b = new complex(sc.nextInt(), sc.nextInt());

            complex c = (a.add(b)).multi(a);
            complex d = (a.add(b)).multi(a.add(b));

            System.out.println(c + ", " + d);
        }
    }
}
