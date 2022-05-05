penrose penrose; // define objects

void setup(){
  size(900, 900);
  penrose = new penrose(800, 125, 50, 50); // generate object
}

void draw(){
  background(255);
  penrose.display();
}
