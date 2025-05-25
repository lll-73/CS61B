public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public double G=6.67e-11;
	
	public Planet(double xP,double yP,double xV,double yV,double m,String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}

	public Planet(Planet p){
		xxPos=p.xxPos;
		yyPos=p.yyPos;
		xxVel=p.xxVel;
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName;

	}

	public double calcDistance(Planet p){
		return Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos)+(yyPos-p.yyPos)*(yyPos-p.yyPos));
	}

	public double calcForceExertedBy(Planet p){
		return G*mass*p.mass/Math.pow(calcDistance(p),2);
	}

	public double calcForceExertedByX(Planet p){
		double dx=xxPos-p.xxPos;
		if (dx>0){
			return calcForceExertedBy(p)*dx/calcDistance(p);
		} else {
		return -calcForceExertedBy(p)*dx/calcDistance(p);
		}
	}
	public double calcForceExertedByY(Planet p){	
		double dy=yyPos-p.yyPos;
		if (dy>0){
			return calcForceExertedBy(p)*dy/calcDistance(p);
		} else {
		return -calcForceExertedBy(p)*dy/calcDistance(p);
		}
	}
	
	public double calcNetForceExertedByX(Planet[] allPlanet){
		double totalForce=0;
		for (Planet planet:allPlanet){
			if (this.equals(planet)){
				continue;
			}
			totalForce+=calcForceExertedByX(planet);
		}
		return totalForce;
	}

	public double calcNetForceExertedByY(Planet[] allPlanet){
		double totalForce=0;
		for (Planet planet:allPlanet){
			if (this.equals(planet)){
				continue;
			}
			totalForce+=calcForceExertedByY(planet);
		}
		return totalForce;
	}

	public void update(double t,double xN,double yN){
		double ax=xN/mass;
		double ay=yN/mass;
		xxVel=xxVel+t*ax;
		yyVel=yyVel+t*ay;
		xxPos=xxPos+t*xxVel;
		yyPos=yyPos+t*yyVel;
	}

}
