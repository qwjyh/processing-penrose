penrose penrose; // define objects

void setup(){
  size(200, 200);
  penrose = new penrose(135, 25, width/2, height/2, #CCCCCC,PI/240); // generate object
  frameRate(60);
  delay(2000);
}

void draw(){
  background(255);
  //penrose.move();
  //penrose.display();
  penrose.rot_display();
}
