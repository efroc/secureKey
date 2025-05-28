package classes;

public class Triple<A, B, C> {
    
    private A first;
    private B second;
    private C third;

    /********* Constructeurs *********/
    public Triple() {
    }

    public Triple(A fst, B snd, C thd) {
        this.first = fst;
        this.second = snd;
        this.third = thd;
    }

    /********* Getters-Setters ********/
    public A getFirst() {
        return this.first;
    }

    public B getSecond() {
        return this.second;
    }

    public C getThird() {
        return this.third;
    }

    public void setFirst(A fst) {
        this.first = fst;
    }

    public void setSecond(B snd) {
        this.second = snd;
    }

    public void setThird(C thd) {
        this.third = thd;
    }

    /************ Fonctions *************/
    public String toString() {
        return " | " + this.first + " | Username : " + this.second + " | Password : " + this.third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triple)) return false;
        Triple<?, ?, ?> triplet = (Triple<?, ?, ?>) o;
        return first.equals(triplet.first) &&
               second.equals(triplet.second) &&
               third.equals(triplet.third);
    }
}
