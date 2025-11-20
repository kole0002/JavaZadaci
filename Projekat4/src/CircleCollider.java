public class CircleCollider implements Collidable {
    private int centerX, centerY, radius;

    public CircleCollider(int centerX, int centerY, int radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius mora biti > 0");
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getCenterX() { return centerX; }
    public int getCenterY() { return centerY; }
    public int getRadius() { return radius; }

    public void setCenterX(int centerX) { this.centerX = centerX; }
    public void setCenterY(int centerY) { this.centerY = centerY; }
    public void setRadius(int radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius mora biti > 0");
        this.radius = radius;
    }

    private static int clamp(int val, int min, int max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }

    @Override
    public boolean intersects(Collidable other) {
        if (other == null) return false;
        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;
            long dx = (long) this.centerX - c.centerX;
            long dy = (long) this.centerY - c.centerY;
            long dist2 = dx * dx + dy * dy;
            long radSum = (long) this.radius + c.radius;
            return dist2 <= radSum * radSum;
        } else if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            int nearestX = clamp(this.centerX, r.getX(), r.getX() + r.getWidth());
            int nearestY = clamp(this.centerY, r.getY(), r.getY() + r.getHeight());
            long dx = (long) this.centerX - nearestX;
            long dy = (long) this.centerY - nearestY;
            long dist2 = dx * dx + dy * dy;
            return dist2 <= (long) this.radius * this.radius;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Circle r=" + radius + " @ (" + centerX + "," + centerY + ")";
    }
}