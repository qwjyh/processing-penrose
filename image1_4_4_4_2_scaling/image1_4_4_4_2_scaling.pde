penrose[] penrose = new penrose[30]; // define objects

void setup() {
  size(400, 400);
  for (int i = 0; i < penrose.length; i++) {
    float x = random(10, 250);
    float y = random(2, x/4);
      penrose[i] = new penrose(x, y, random(width), random(-x, height), color(random(255), random(255), random(255)));
  }
}

void draw() {
  background(255);
  for (int i=0 ; i < penrose.length; i++) {
    penrose[i].move();
    penrose[i].display();
  }
}
