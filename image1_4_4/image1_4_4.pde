penrose penrose; // define objects

void setup(){
  size(300, 400);
  penrose = new penrose(160, 25, 50, 50); // generate object
}

void draw(){
  background(255);
  penrose.display();
}
