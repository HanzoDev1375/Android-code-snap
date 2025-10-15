package ir.ninjacoder.codesnap.widget.editorbase;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;

import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PowerModeEditText extends AppCompatMultiAutoCompleteTextView {

  
  private EffectType currentEffect = EffectType.NONE;
  private Paint particlePaint;
  private List<Particle> particles = new ArrayList<>();
  private Random random = new Random();
  private long lastUpdateTime;
  private Map<Character, Integer> charColors = new HashMap<>();
  private SparseArray<Long> lastCharTime = new SparseArray<>();
  private int[] rainbowColors;
  private int colorIndex = 0;
  private long lastColorChangeTime = 0;
  private Bitmap sparkleBitmap;
  private Bitmap starBitmap;

  // تنظیمات افکت
  private boolean enableScreenShake = true;
  private float shakeIntensity = 1.0f;
  private boolean enableSoundEffects = false;
  private boolean enableColorCycling = true;
  private float effectIntensity = 1.0f;

  public PowerModeEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public PowerModeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  public PowerModeEditText(Context context) {
    super(context);
    init();
  }
  
  public EffectType getEffectTypes(){
    return currentEffect;
  }

  private void init() {
    particlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    particlePaint.setStyle(Paint.Style.FILL);
    lastUpdateTime = System.currentTimeMillis();

    // رنگ‌های رنگین کمان برای افکت‌های خاص
    rainbowColors = new int[] {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};

    // ایجاد بیت‌مپ‌های برای افکت‌های خاص
    sparkleBitmap = createSparkleBitmap(20);
    starBitmap = createStarBitmap(15);

    addTextChangedListener(
        new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (count > 0) {
              spawnEffectAtCursor();
              if (enableScreenShake && currentEffect == EffectType.EXPLOSION) {
                postDelayed(() -> shakeScreen(15 * shakeIntensity), 50);
              }
              invalidate();
            }
          }

          @Override
          public void afterTextChanged(Editable s) {}
        });
  }

  public void setEffect(EffectType type) {
    this.currentEffect = type;
    particles.clear();
  }

  public void setEffectIntensity(float intensity) {
    this.effectIntensity = Math.max(0.1f, Math.min(5.0f, intensity));
  }

  public void setShakeIntensity(float intensity) {
    this.shakeIntensity = Math.max(0.0f, Math.min(2.0f, intensity));
  }

  public void enableScreenShake(boolean enable) {
    this.enableScreenShake = enable;
  }

  public void enableColorCycling(boolean enable) {
    this.enableColorCycling = enable;
  }

  private void spawnEffectAtCursor() {
    int offset = getSelectionStart();
    Layout layout = getLayout();
    if (layout == null || offset <= 0) return;

    float x = layout.getPrimaryHorizontal(offset - 1);
    int line = layout.getLineForOffset(offset - 1);
    float y = layout.getLineBaseline(line) + layout.getLineAscent(line);

    // در نظر گرفتن padding و scroll
    x += getTotalPaddingLeft() - getScrollX();
    y += getTotalPaddingTop() - getScrollY();

    switch (currentEffect) {
      case PARTICLE:
        spawnParticles(x, y);
        break;
      case LIGHTNING:
        spawnLightning(x, y);
        break;
      case FLAME:
        spawnFlame(x, y);
        break;
      case SPARK:
        spawnSpark(x, y);
        break;
      case RAIN:
        spawnRain(x, y);
        break;
      case MAGIC:
        spawnMagic(x, y);
        break;
      case EXPLOSION:
        spawnExplosion(x, y);
        break;
      case BUBBLE:
        spawnBubbles(x, y);
        break;
      case NEON:
        spawnNeonEffect(x, y);
        break;
      case GLITCH:
        spawnGlitchEffect(x, y);
        break;
      case GALAXY:
        spawnGalaxyEffect(x, y);
        break;
      case TYPING:
        spawnTypingEffect(x, y);
        break;
    }
  }

  // --- افکت‌های جدید و بهبود یافته ---

  private void spawnParticles(float x, float y) {
    int count = (int) (15 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 8 * effectIntensity + 2;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int color;
      if (enableColorCycling) {
        color = getCyclingColor();
      } else {
        color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
      }

      float size = random.nextFloat() * 5 * effectIntensity + 2;
      float gravity = 0.2f * effectIntensity;
      float friction = 0.97f;
      int life = (int) (30 + random.nextInt(20) * effectIntensity);

      // 30% chance for a special particle
      if (random.nextFloat() < 0.3f) {
        particles.add(
            new SparkleParticle(x, y, dx, dy, color, size, gravity, friction, life, sparkleBitmap));
      } else {
        particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
      }
    }
  }

  private void spawnLightning(float x, float y) {
    int mainBranches = (int) (2 + random.nextInt(3) * effectIntensity);

    for (int i = 0; i < mainBranches; i++) {
      float startX = x;
      float startY = y;
      float endX = x + (random.nextFloat() - 0.5f) * 200 * effectIntensity;
      float endY = y - random.nextInt((int) (600 * effectIntensity)) - 300;

      int mainColor = Color.argb(240, 70, 130, 255);
      int segments = (int) (15 + random.nextInt(10) * effectIntensity);

      particles.add(
          new LightningParticle(
              startX, startY, endX, endY, mainColor, segments, 4f * effectIntensity));

      int subBranches = (int) (3 + random.nextInt(5) * effectIntensity);
      for (int j = 0; j < subBranches; j++) {
        float splitPoint = 0.3f + random.nextFloat() * 0.5f;
        float splitX = startX + (endX - startX) * splitPoint;
        float splitY = startY + (endY - startY) * splitPoint;

        float subEndX = splitX + (random.nextFloat() - 0.5f) * 200 * effectIntensity;
        float subEndY = splitY - random.nextInt((int) (200 * effectIntensity)) - 100;

        int subColor = Color.argb(200, 100, 160, 255);
        int subSegments = (int) (8 + random.nextInt(10) * effectIntensity);

        particles.add(
            new LightningParticle(
                splitX, splitY, subEndX, subEndY, subColor, subSegments, 2f * effectIntensity));
      }

      particles.add(
          new LightningGlow(
              startX,
              startY,
              endX,
              endY,
              Color.argb(100, 100, 180, 255),
              20 * effectIntensity,
              segments));
    }

    for (int i = 0; i < 4 * effectIntensity; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float distance = random.nextFloat() * 100 * effectIntensity + 50;
      float sparkX = x + (float) Math.cos(angle) * distance;
      float sparkY = y + (float) Math.sin(angle) * distance;

      int sparkColor = Color.argb(220, 200, 220, 255);
      float size = random.nextFloat() * 3 * effectIntensity + 1;

      particles.add(
          new CircleParticle(
              x, y, (sparkX - x) * 0.1f, (sparkY - y) * 0.1f, sparkColor, size, 0, 0.9f, 10));
    }
  }

  private void spawnFlame(float x, float y) {
    int count = (int) (12 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float dx = (random.nextFloat() - 0.5f) * 4 * effectIntensity;
      float dy = -random.nextFloat() * 8 * effectIntensity - 4;

      int color = Color.argb(200, 255, 100 + random.nextInt(156), random.nextInt(100));

      float size = random.nextFloat() * 6 * effectIntensity + 3;
      float gravity = -0.1f * effectIntensity;
      float friction = 0.96f;
      int life = (int) (30 + random.nextInt(30) * effectIntensity);

      // 20% chance for a smoke particle
      if (random.nextFloat() < 0.2f) {
        particles.add(
            new SmokeParticle(
                x,
                y,
                dx * 0.5f,
                dy * 0.7f,
                Color.argb(150, 100, 100, 100),
                size * 1.5f,
                gravity * 0.3f,
                friction,
                life * 2));
      } else {
        particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
      }
    }
  }

  private void spawnSpark(float x, float y) {
    int count = (int) (10 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 15 * effectIntensity + 5;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int color = Color.argb(220, 255, 200 + random.nextInt(55), random.nextInt(100));
      float size = random.nextFloat() * 3 * effectIntensity + 1;
      float gravity = 0.3f * effectIntensity;
      float friction = 0.9f;
      int life = (int) (15 + random.nextInt(10) * effectIntensity);

      particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }
  }

  private void spawnRain(float x, float y) {
    int count = (int) (15 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = (float) Math.toRadians(75 + random.nextInt(10));
      float speed = random.nextFloat() * 25 * effectIntensity + 15;

      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int blueShade = 150 + random.nextInt(106);
      int color = Color.argb(200, 100, 100, blueShade);

      float length = random.nextFloat() * 25 * effectIntensity + 20;
      float thickness = random.nextFloat() * 1.5f * effectIntensity + 1f;

      particles.add(new RainParticle(x, y, dx, dy, color, length, thickness));
    }

    spawnRainSplash(x, getHeight());
  }

  private void spawnRainSplash(float x, float groundLevel) {
    for (int i = 0; i < 5 * effectIntensity; i++) {
      float splashX = x + (random.nextFloat() - 0.5f) * 30 * effectIntensity;
      float splashY = groundLevel - 5;

      for (int j = 0; j < 3 * effectIntensity; j++) {
        float angle = (float) (Math.PI / 2 + (random.nextFloat() - 0.5f) * Math.PI / 4);
        float speed = random.nextFloat() * 5 * effectIntensity + 2;

        float dx = (float) Math.cos(angle) * speed;
        float dy = -(float) Math.sin(angle) * speed;

        int color = Color.argb(180, 150, 150, 255);
        float size = random.nextFloat() * 2 * effectIntensity + 1;

        particles.add(new CircleParticle(splashX, splashY, dx, dy, color, size, 0.4f, 0.9f, 15));
      }
    }
  }

  private void spawnMagic(float x, float y) {
    int count = (int) (20 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 6 * effectIntensity + 2;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int[] magicColors = {
        Color.argb(220, 180, 70, 255), Color.argb(220, 70, 130, 255), Color.argb(220, 255, 70, 220)
      };
      int color = magicColors[random.nextInt(magicColors.length)];

      float size = random.nextFloat() * 4 * effectIntensity + 2;
      float gravity = -0.05f * effectIntensity;
      float friction = 0.98f;
      int life = (int) (40 + random.nextInt(30) * effectIntensity);

      // 15% chance for a star particle
      if (random.nextFloat() < 0.15f) {
        particles.add(
            new StarParticle(
                x, y, dx, dy, color, size * 1.5f, gravity, friction, life, starBitmap));
      } else {
        particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
      }
    }
  }

  private void spawnExplosion(float x, float y) {
    int count = (int) (25 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 20 * effectIntensity + 5;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int color = Color.argb(220, 255, 100 + random.nextInt(156), random.nextInt(100));

      float size = random.nextFloat() * 8 * effectIntensity + 4;
      float gravity = 0.4f * effectIntensity;
      float friction = 0.92f;
      int life = (int) (25 + random.nextInt(15) * effectIntensity);

      particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }

    // Add shockwave effect
    particles.add(
        new ShockwaveParticle(x, y, Color.argb(150, 255, 200, 50), 100 * effectIntensity, 30));
  }

  private void spawnBubbles(float x, float y) {
    int count = (int) (8 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float dx = (random.nextFloat() - 0.5f) * 2 * effectIntensity;
      float dy = -random.nextFloat() * 6 * effectIntensity - 2;

      int color = Color.argb(180, 150, 220, 255);
      float size = random.nextFloat() * 15 * effectIntensity + 5;
      float gravity = -0.15f * effectIntensity;
      float friction = 0.99f;
      int life = (int) (60 + random.nextInt(40) * effectIntensity);

      particles.add(new BubbleParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }
  }

  private void spawnNeonEffect(float x, float y) {
    int count = (int) (12 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 4 * effectIntensity + 1;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int[] neonColors = {
        Color.argb(220, 255, 50, 50), // Red
        Color.argb(220, 50, 255, 50), // Green
        Color.argb(220, 50, 50, 255), // Blue
        Color.argb(220, 255, 50, 255), // Pink
        Color.argb(220, 50, 255, 255), // Cyan
        Color.argb(220, 255, 255, 50) // Yellow
      };
      int color = neonColors[random.nextInt(neonColors.length)];

      float size = random.nextFloat() * 6 * effectIntensity + 3;
      float gravity = 0.05f * effectIntensity;
      float friction = 0.95f;
      int life = (int) (40 + random.nextInt(20) * effectIntensity);

      particles.add(new NeonParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }

    // Add glow effect
    particles.add(
        new RadialGlowParticle(x, y, Color.argb(100, 100, 255, 255), 80 * effectIntensity, 20));
  }

  private void spawnGlitchEffect(float x, float y) {
    int count = (int) (5 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float dx = (random.nextFloat() - 0.5f) * 10 * effectIntensity;
      float dy = (random.nextFloat() - 0.5f) * 10 * effectIntensity;

      int color =
          Color.argb(
              200, random.nextInt(100) + 155, random.nextInt(100) + 50, random.nextInt(100) + 155);

      float size = random.nextFloat() * 8 * effectIntensity + 4;
      int life = (int) (15 + random.nextInt(10) * effectIntensity);

      particles.add(new GlitchParticle(x, y, dx, dy, color, size, life));
    }

    // Screen shake for glitch effect
    if (enableScreenShake) {
      postDelayed(() -> shakeScreen(5 * shakeIntensity), 10);
    }
  }

  private void spawnGalaxyEffect(float x, float y) {
    int count = (int) (20 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 5 * effectIntensity + 1;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int[] galaxyColors = {
        Color.argb(220, 150, 100, 255), // Purple
        Color.argb(220, 100, 150, 255), // Blue
        Color.argb(220, 255, 100, 200), // Pink
        Color.argb(220, 100, 255, 200) // Teal
      };
      int color = galaxyColors[random.nextInt(galaxyColors.length)];

      float size = random.nextFloat() * 4 * effectIntensity + 2;
      float gravity = -0.02f * effectIntensity;
      float friction = 0.98f;
      int life = (int) (50 + random.nextInt(30) * effectIntensity);

      // 25% chance for a star particle
      if (random.nextFloat() < 0.25f) {
        particles.add(
            new StarParticle(x, y, dx, dy, color, size * 2, gravity, friction, life, starBitmap));
      } else {
        particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
      }
    }

    // Add spiral effect
    particles.add(
        new SpiralParticle(x, y, Color.argb(150, 200, 150, 255), 100 * effectIntensity, 40));
  }

  private void spawnTypingEffect(float x, float y) {
    int count = (int) (5 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float dx = (random.nextFloat() - 0.5f) * 3 * effectIntensity;
      float dy = -random.nextFloat() * 5 * effectIntensity - 2;

      int color = getCyclingColor();
      float size = random.nextFloat() * 4 * effectIntensity + 2;
      float gravity = 0.1f * effectIntensity;
      float friction = 0.95f;
      int life = (int) (20 + random.nextInt(10) * effectIntensity);

      particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }
  }

  // --- متدهای کمکی ---

  private int getCyclingColor() {
    if (System.currentTimeMillis() - lastColorChangeTime > 100) {
      colorIndex = (colorIndex + 1) % rainbowColors.length;
      lastColorChangeTime = System.currentTimeMillis();
    }
    return rainbowColors[colorIndex];
  }

  private void shakeScreen(float intensity) {
    if (!enableScreenShake) return;

    final float shakeRange = intensity * 5f;
    final int duration = 300;
    final long startTime = System.currentTimeMillis();

    final Runnable shakeRunnable =
        new Runnable() {
          @Override
          public void run() {
            long elapsed = System.currentTimeMillis() - startTime;
            if (elapsed < duration) {
              float progress = (float) elapsed / duration;
              float offsetX = (random.nextFloat() - 0.5f) * shakeRange * (1 - progress);
              float offsetY = (random.nextFloat() - 0.5f) * shakeRange * (1 - progress);

              setTranslationX(offsetX);
              setTranslationY(offsetY);

              postDelayed(this, 16);
            } else {
              setTranslationX(0);
              setTranslationY(0);
            }
          }
        };

    post(shakeRunnable);
  }

  private Bitmap createSparkleBitmap(int size) {
    Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    // Draw sparkle shape
    paint.setColor(Color.WHITE);
    canvas.drawCircle(size / 2, size / 2, size / 4, paint);

    // Draw rays
    for (int i = 0; i < 8; i++) {
      float angle = (float) (i * Math.PI / 4);
      float x1 = (float) (size / 2 + Math.cos(angle) * size / 4);
      float y1 = (float) (size / 2 + Math.sin(angle) * size / 4);
      float x2 = (float) (size / 2 + Math.cos(angle) * size / 2);
      float y2 = (float) (size / 2 + Math.sin(angle) * size / 2);

      paint.setStrokeWidth(2);
      canvas.drawLine(x1, y1, x2, y2, paint);
    }

    return bitmap;
  }

  private Bitmap createStarBitmap(int size) {
    Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    paint.setColor(Color.WHITE);

    Path path = new Path();
    path.moveTo(size / 2, 0);
    path.lineTo(size * 0.6f, size * 0.4f);
    path.lineTo(size, size * 0.4f);
    path.lineTo(size * 0.7f, size * 0.6f);
    path.lineTo(size * 0.8f, size);
    path.lineTo(size / 2, size * 0.7f);
    path.lineTo(size * 0.2f, size);
    path.lineTo(size * 0.3f, size * 0.6f);
    path.lineTo(0, size * 0.4f);
    path.lineTo(size * 0.4f, size * 0.4f);
    path.close();

    canvas.drawPath(path, paint);
    return bitmap;
  }

  @Override
  protected void onDraw(Canvas canvas) {
    // Save canvas state for potential transformations
    canvas.save();

    super.onDraw(canvas);

    long currentTime = System.currentTimeMillis();
    float deltaTime = (currentTime - lastUpdateTime) / 1000.0f;
    lastUpdateTime = currentTime;

    // Update and draw particles
    Iterator<Particle> iterator = particles.iterator();
    while (iterator.hasNext()) {
      Particle p = iterator.next();
      p.update(deltaTime);
      if (p.life <= 0) {
        //  iterator.remove();
      } else {
        p.draw(canvas, particlePaint);
      }
    }

    // Restore canvas state
    canvas.restore();

    if (!particles.isEmpty()) {
      postInvalidateOnAnimation();
    }
  }

  // --- کلاس‌های پارتیکل بهبود یافته و جدید ---

  private abstract static class Particle {
    float x, y;
    int life;
    int initialLife;
    int alpha;
    int color;
    float gravity;
    float friction;

    Particle(float x, float y, int color, int life, float gravity, float friction) {
      this.x = x;
      this.y = y;
      this.color = color;
      this.life = life;
      this.initialLife = life;
      this.alpha = 255;
      this.gravity = gravity;
      this.friction = friction;
    }

    void update(float deltaTime) {
      life--;
      alpha = (int) (255 * ((float) life / initialLife));
    }

    abstract void draw(Canvas canvas, Paint paint);
  }

  private static class CircleParticle extends Particle {
    float dx, dy;
    float size;

    CircleParticle(
        float x,
        float y,
        float dx,
        float dy,
        int color,
        float size,
        float gravity,
        float friction,
        int life) {
      super(x, y, color, life, gravity, friction);
      this.dx = dx;
      this.dy = dy;
      this.size = size;
    }

    @Override
    void update(float deltaTime) {
      super.update(deltaTime);

      dy += gravity;
      dx *= friction;
      dy *= friction;

      x += dx * deltaTime * 60;
      y += dy * deltaTime * 60;
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      paint.setColor(color);
      paint.setAlpha(alpha);
      canvas.drawCircle(x, y, size, paint);
    }
  }

  private static class SparkleParticle extends CircleParticle {
    private Bitmap sparkleBitmap;
    private Matrix matrix = new Matrix();
    private float rotation;
    private float rotationSpeed;

    SparkleParticle(
        float x,
        float y,
        float dx,
        float dy,
        int color,
        float size,
        float gravity,
        float friction,
        int life,
        Bitmap sparkleBitmap) {
      super(x, y, dx, dy, color, size, gravity, friction, life);
      this.sparkleBitmap = sparkleBitmap;
      this.rotation = (float) (Math.random() * 360);
      this.rotationSpeed = (float) (Math.random() * 10 - 5);
    }

    @Override
    void update(float deltaTime) {
      super.update(deltaTime);
      rotation += rotationSpeed;
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      matrix.reset();
      matrix.postTranslate(-sparkleBitmap.getWidth() / 2, -sparkleBitmap.getHeight() / 2);
      matrix.postRotate(rotation);
      matrix.postScale(size * 2 / sparkleBitmap.getWidth(), size * 2 / sparkleBitmap.getHeight());
      matrix.postTranslate(x, y);

      paint.setAlpha(alpha);
      canvas.drawBitmap(sparkleBitmap, matrix, paint);
    }
  }

  private static class StarParticle extends SparkleParticle {
    StarParticle(
        float x,
        float y,
        float dx,
        float dy,
        int color,
        float size,
        float gravity,
        float friction,
        int life,
        Bitmap starBitmap) {
      super(x, y, dx, dy, color, size, gravity, friction, life, starBitmap);
    }
  }

  private static class LightningParticle extends Particle {
    float endX, endY;
    int segments;
    Path lightningPath;
    float jitter;
    float thickness;

    LightningParticle(
        float startX,
        float startY,
        float endX,
        float endY,
        int color,
        int segments,
        float thickness) {
      super(startX, startY, color, 8, 0, 1);
      this.endX = endX;
      this.endY = endY;
      this.segments = segments;
      this.thickness = thickness;
      this.jitter = 30f;
      createLightningPath();
    }

    private void createLightningPath() {
      lightningPath = new Path();
      lightningPath.moveTo(x, y);

      float dx = (endX - x) / segments;
      float dy = (endY - y) / segments;

      float prevX = x;
      float prevY = y;

      for (int i = 1; i < segments; i++) {
        float midX = prevX + dx;
        float midY = prevY + dy;

        float segmentProgress = (float) i / segments;
        float currentJitter = jitter * (1.0f - segmentProgress * 0.7f);

        midX += (Math.random() - 0.5) * currentJitter;
        midY += (Math.random() - 0.5) * currentJitter;

        lightningPath.lineTo(midX, midY);
        prevX = midX;
        prevY = midY;
      }

      lightningPath.lineTo(endX, endY);
    }

    @Override
    void update(float deltaTime) {
      super.update(deltaTime);

      if (life % 3 == 0) {
        createLightningPath();
      }
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      paint.setColor(color);
      paint.setAlpha(alpha);
      paint.setStrokeWidth(thickness);
      paint.setStyle(Paint.Style.STROKE);
      canvas.drawPath(lightningPath, paint);

      if (thickness > 2) {
        paint.setColor(Color.WHITE);
        paint.setAlpha(alpha / 2);
        paint.setStrokeWidth(thickness / 3);
        canvas.drawPath(lightningPath, paint);
      }
    }
  }

  private static class LightningGlow extends Particle {
    float endX, endY;
    int segments;
    Path lightningPath;
    float glowSize;

    LightningGlow(
        float startX,
        float startY,
        float endX,
        float endY,
        int color,
        float glowSize,
        int segments) {
      super(startX, startY, color, 5, 0, 1);
      this.endX = endX;
      this.endY = endY;
      this.glowSize = glowSize;
      this.segments = segments;
      createLightningPath();
    }

    private void createLightningPath() {
      lightningPath = new Path();
      lightningPath.moveTo(x, y);

      float dx = (endX - x) / segments;
      float dy = (endY - y) / segments;

      float prevX = x;
      float prevY = y;

      for (int i = 1; i < segments; i++) {
        float midX = prevX + dx;
        float midY = prevY + dy;

        midX += (Math.random() - 0.5) * 15;
        midY += (Math.random() - 0.5) * 15;

        lightningPath.lineTo(midX, midY);
        prevX = midX;
        prevY = midY;
      }

      lightningPath.lineTo(endX, endY);
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      paint.setColor(color);
      paint.setAlpha(alpha);
      paint.setStrokeWidth(glowSize);
      paint.setStyle(Paint.Style.STROKE);

      paint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
      canvas.drawPath(lightningPath, paint);
      paint.setMaskFilter(null);
    }
  }

  private class RainParticle extends Particle {
    float dx, dy;
    float length;
    float thickness;

    RainParticle(float x, float y, float dx, float dy, int color, float length, float thickness) {
      super(x, y, color, (int) (30 * (length / 25)), 0.5f, 1);
      this.dx = dx;
      this.dy = dy;
      this.length = length;
      this.thickness = thickness;
    }

    @Override
    void update(float deltaTime) {
      super.update(deltaTime);

      dy += gravity * 2;

      x += dx * deltaTime * 60;
      y += dy * deltaTime * 60;

      if (y >= getHeight() && life > 5) {
        life = 5;
      }
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      paint.setColor(color);
      paint.setAlpha(alpha);
      paint.setStrokeWidth(thickness);

      float endX = x - dx * 0.3f;
      float endY = y - length;
      canvas.drawLine(x, y, endX, endY, paint);

      if (life > 5) {
        paint.setStrokeWidth(thickness * 1.5f);
        canvas.drawPoint(endX, endY, paint);
      }
    }
  }

  private static class BubbleParticle extends CircleParticle {
    private float waveAmount;
    private float waveSpeed;

    BubbleParticle(
        float x,
        float y,
        float dx,
        float dy,
        int color,
        float size,
        float gravity,
        float friction,
        int life) {
      super(x, y, dx, dy, color, size, gravity, friction, life);
      this.waveAmount = (float) (Math.random() * 0.5);
      this.waveSpeed = (float) (Math.random() * 2 + 1);
    }

    @Override
    void update(float deltaTime) {
      // Add horizontal wave motion
      x += (float) Math.sin(waveSpeed * life * 0.1) * waveAmount;

      super.update(deltaTime);
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      // Draw bubble with highlight
      paint.setColor(color);
      paint.setAlpha(alpha);
      canvas.drawCircle(x, y, size, paint);

      // Draw highlight
      paint.setColor(Color.argb(alpha / 2, 255, 255, 255));
      canvas.drawCircle(x - size / 3, y - size / 3, size / 4, paint);
    }
  }

  private static class NeonParticle extends CircleParticle {
    private Paint glowPaint;

    NeonParticle(
        float x,
        float y,
        float dx,
        float dy,
        int color,
        float size,
        float gravity,
        float friction,
        int life) {
      super(x, y, dx, dy, color, size, gravity, friction, life);

      glowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
      glowPaint.setColor(color);
      glowPaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      // Draw glow
      glowPaint.setAlpha(alpha / 2);
      canvas.drawCircle(x, y, size * 2, glowPaint);

      // Draw core
      paint.setColor(color);
      paint.setAlpha(alpha);
      canvas.drawCircle(x, y, size, paint);
    }
  }

  private static class GlitchParticle extends Particle {
    float dx, dy;
    float size;

    GlitchParticle(float x, float y, float dx, float dy, int color, float size, int life) {
      super(x, y, color, life, 0, 1);
      this.dx = dx;
      this.dy = dy;
      this.size = size;
    }

    @Override
    void update(float deltaTime) {
      super.update(deltaTime);

      // Glitch particles don't move smoothly
      if (life % 3 == 0) {
        x += dx;
        y += dy;
      }
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      paint.setColor(color);
      paint.setAlpha(alpha);

      // Draw glitch as a rectangle
      canvas.drawRect(x - size / 2, y - size / 2, x + size / 2, y + size / 2, paint);
    }
  }

  private static class RadialGlowParticle extends Particle {
    float radius;

    RadialGlowParticle(float x, float y, int color, float radius, int life) {
      super(x, y, color, life, 0, 1);
      this.radius = radius;
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      RadialGradient gradient =
          new RadialGradient(
              x,
              y,
              radius,
              Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color)),
              Color.TRANSPARENT,
              Shader.TileMode.CLAMP);

      paint.setShader(gradient);
      canvas.drawCircle(x, y, radius, paint);
      paint.setShader(null);
    }
  }

  private static class ShockwaveParticle extends Particle {
    float radius;
    float maxRadius;

    ShockwaveParticle(float x, float y, int color, float maxRadius, int life) {
      super(x, y, color, life, 0, 1);
      this.radius = 0;
      this.maxRadius = maxRadius;
    }

    @Override
    void update(float deltaTime) {
      super.update(deltaTime);
      radius = maxRadius * (1 - (float) life / initialLife);
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      paint.setColor(color);
      paint.setAlpha(alpha);
      paint.setStyle(Paint.Style.STROKE);
      paint.setStrokeWidth(5);

      canvas.drawCircle(x, y, radius, paint);
    }
  }

  private static class SpiralParticle extends Particle {
    float radius;
    float angle;
    float maxRadius;

    SpiralParticle(float x, float y, int color, float maxRadius, int life) {
      super(x, y, color, life, 0, 1);
      this.radius = 0;
      this.angle = 0;
      this.maxRadius = maxRadius;
    }

    @Override
    void update(float deltaTime) {
      super.update(deltaTime);
      radius = maxRadius * (1 - (float) life / initialLife);
      angle += 0.1;
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      paint.setColor(color);
      paint.setAlpha(alpha);
      paint.setStyle(Paint.Style.STROKE);
      paint.setStrokeWidth(3);

      Path path = new Path();
      int points = 50;

      for (int i = 0; i <= points; i++) {
        float progress = (float) i / points;
        float currentRadius = radius * progress;
        float currentAngle = angle + progress * 10;

        float px = x + (float) Math.cos(currentAngle) * currentRadius;
        float py = y + (float) Math.sin(currentAngle) * currentRadius;

        if (i == 0) {
          path.moveTo(px, py);
        } else {
          path.lineTo(px, py);
        }
      }

      canvas.drawPath(path, paint);
    }
  }

  private static class SmokeParticle extends CircleParticle {
    SmokeParticle(
        float x,
        float y,
        float dx,
        float dy,
        int color,
        float size,
        float gravity,
        float friction,
        int life) {
      super(x, y, dx, dy, color, size, gravity, friction, life);
    }

    @Override
    void update(float deltaTime) {
      super.update(deltaTime);

      // Smoke expands as it rises
      size += 0.1;
    }
  }

  private static class TrailParticle extends Particle {
    float size;
    List<float[]> previousPositions = new ArrayList<>();

    TrailParticle(float x, float y, int color, int life, float size) {
      super(x, y, color, life, 0, 1);
      this.size = size;
    }

    @Override
    void update(float deltaTime) {
      super.update(deltaTime);

      // Store current position
      previousPositions.add(0, new float[] {x, y});

      // Remove old positions
      if (previousPositions.size() > 10) {
        previousPositions.remove(previousPositions.size() - 1);
      }
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      if (previousPositions.size() < 2) return;

      paint.setColor(color);

      for (int i = 0; i < previousPositions.size() - 1; i++) {
        float[] point = previousPositions.get(i);
        float trailAlpha = alpha * (1 - (float) i / previousPositions.size());
        paint.setAlpha((int) trailAlpha);

        float trailSize = size * (1 - (float) i / previousPositions.size());
        canvas.drawCircle(point[0], point[1], trailSize, paint);
      }
    }
  }
}
