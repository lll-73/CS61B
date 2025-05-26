public class NBody{
	public static int N;
	public static double R;
	
	public static double readRadius(String filename){
		In in =new In(filename);
		N=in.readInt();
		R=in.readDouble();
		return R;
	}

	public static Planet[] readPlanets(String filename){
		readRadius(filename);
		In in =new In(filename);
		Planet[] planets=new Planet[N];
		in.readInt();
		in.readDouble();
		for (int i=0;i<N;i++){
			planets[i]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		}
		return planets;
	}
	public static String imageToDraw ="images/starfield.jpg";
	public static void main(String[] args){
		StdDraw.enableDoubleBuffering();
		double T=Double.valueOf(args[0]);
		double dt=Double.valueOf(args[1]);
		String filename=args[2];
		Planet[] planets=readPlanets(filename);
		StdDraw.setScale(-R,R);
		StdDraw.clear();
		double time=0;
		while (time<=T){
			StdDraw.clear();
			double[] xForces=new double[N];
			double[] yForces=new double[N];
			for (int i=0;i<N;i++){
				xForces[i]=planets[i].calcNetForceExertedByX(planets);
				yForces[i]=planets[i].calcNetForceExertedByY(planets);
			}

			for (int i=0;i<N;i++){
				planets[i].update(dt,xForces[i],yForces[i]);
			}

			StdDraw.picture(0,0,imageToDraw);

			for (Planet planet:planets){
				planet.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time=time+dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", R);
		for (int i = 0; i < planets.length; i++) {
    			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  			planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  			planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}
	}
}
