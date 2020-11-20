penrose penrose; // define objects

void setup(){
  size(400, 400);
  penrose = new penrose(160, 25, 50, 50, #ABCDEF); // generate object
}

void draw(){
  background(255);
  penrose.move();
  penrose.display();
}
