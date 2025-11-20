public class RectangleCollider implements Collidable {
    private int x, y, width, height;

    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Rectangle dimenzije moraju biti > 0");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setWidth(int width) {
        if (width <= 0) throw new IllegalArgumentException("Sirina mora biti > 0");
        this.width = width;
    }
    public void setHeight(int height) {
        if (height <= 0) throw new IllegalArgumentException("Visina mora biti > 0");
        this.height = height;
    }

    @Override
    public boolean intersects(Collidable other) {
        if (other == null) return false;
        if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            return this.x < r.x + r.width && this.x + this.width > r.x
                    && this.y < r.y + r.height && this.y + this.height > r.y;
        } else if (other instanceof CircleCollider) {
            return other.intersects(this);
        }
        return false;
    }

    @Override
    public String toString() {
        return width + "x" + height + " @ (" + x + "," + y + ")";
    }
}