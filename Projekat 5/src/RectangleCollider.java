public class RectangleCollider implements Collidable {
    private int x, y, width, height;

    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("Width and height must be > 0");
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    @Override
    public boolean intersects(Collidable other) {
        if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            return this.x < r.x + r.width && this.x + this.width > r.x
                    && this.y < r.y + r.height && this.y + this.height > r.y;
        } else if (other instanceof CircleCollider) {
            return other.intersects(this);
        }
        return false;
    }
}
