package solutions.pack1;

public class Dog660261 {
    Breed b;
    int weight;

    public Dog660261(Breed b, int weight)
    {
        this.b = b;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dog [b=" + b + ", weight=" + weight + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((b == null) ? 0 : b.hashCode());
        result = prime * result + weight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dog660261 other = (Dog660261) obj;
        if (b != other.b)
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }

    public Breed getBreed() {
        return b;
    }

    public int getWeight() {
        return weight;
    }

    
}
