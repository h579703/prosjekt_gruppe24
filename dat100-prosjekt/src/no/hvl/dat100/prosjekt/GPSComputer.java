package no.hvl.dat100.prosjekt;

public class GPSComputer {
	
	public GPSComputer(GPSData gpsdata) {

		GPSDataConverter converter = new GPSDataConverter(gpsdata);
		converter.convert();

		this.times = converter.times;
		this.latitudes = converter.latitudes;
		this.longitudes = converter.longitudes;
		this.elevations = converter.elevations;
	}

	// tabeller for GPS datapunkter
	public int[] times;
	public double[] latitudes;
	public double[] longitudes;
	public double[] elevations;
	
	// beregn total distances (i meter)
	public double totalDistance() {

		double distance = 0;

		// TODO
		// OPPGAVE - START
		
		
		for (int i = 0; i<latitudes.length - 1; i++) {
		
		distance += GPSUtils.distance(latitudes[i], longitudes[i], latitudes[i+1], longitudes[i+1]);
		
	
		}
	
		
		// Hint: bruk distance-metoden fra GPSUtils.
		
		// OPPGAVE - SLUTT

		return distance;
	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;

		// TODO
		// OPPGAVE - START
		
		
		
		for (int i = 0; i<elevations.length-1; i++) {
			if (elevations[i+1] > elevations [i]) {
				elevation += (elevations[i+1] - elevations[i]);
				
			}
			
		}
	
		
		// OPPGAVE - SLUTT
		return elevation;
	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {
		
		int totaltime = 0;
		// TODO 
		// OPPGAVE START
		for (int i = 0; i<times.length-1; i++) {
			totaltime += times[i+1] - times[i];
			
		
			
		}
		// OPPGAVE SLUTT
		
		return totaltime;
	}
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene
	public double[] speeds() {

		double[] speeds = new double[times.length-1];
		
		// TODO
		// OPPGAVE - START
		
		
		for (int i = 0; i<times.length-1; i++) {
			int totaltime = times[i+1] - times[i];
			speeds[i] = GPSUtils.speed(totaltime, latitudes[i], longitudes[i], latitudes[i+1], longitudes[i+1]);
		}
		// OPPGAVE - SLUTT
		return speeds;
	}

	// beregn maximum hastighet km/t
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		// TODO
		// OPPGAVE - START
		 
			for (int i = 0; i<times.length - 1; i++) {
			
			int totaltime = times[i+1] - times[i];
			
			double speeds = GPSUtils.speed(totaltime, latitudes[i], longitudes[i], latitudes[i+1], longitudes[i+1]);
			
			maxspeed = Math.max(maxspeed, speeds);
		}
		// OPPGAVE - SLUTT
		
		return maxspeed;
	}
	
	// beregn gjennomsnittshasitiget for hele turen km/t
	public double averageSpeed() {

		double average = 0;
		
		// TODO
		// OPPGAVE - START
			double totaltime = 0;
			double totaldistance = 0;

			for (int i = 0; i<times.length - 1; i++) {
		
				totaltime += times[i+1] - times[i];
		
				double totaltimeToHr = totaltime/3600;
		
				totaldistance += GPSUtils.distance(latitudes[i], longitudes[i], latitudes[i+1], longitudes[i+1]);
		
				double totaldistanceToKm = totaldistance/1000;
		
				average = totaldistanceToKm / totaltimeToHr;

			}
			
		// OPPGAVE - SLUTT
		
		return average;
	}


	// conversion factor kph (km/t) to miles per hour (mph)
	public static double MS = 0.62;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		double kcal = 0;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;		
		double speedmph = speed * MS;

		// TODO
		// OPPGAVE START
		
		
		
			
			if (speedmph < 10) {
				met = 4;
				kcal = met * weight * (secs/3600);
			
			}
			else if (speedmph <= 12) {
				met = 6;
				kcal = met * weight * (secs/3600);
			
			}
			else if (speedmph <= 14) {
				met = 8;
				kcal = met * weight * (secs/3600);
			
			}
			else if (speedmph <= 16) {
				met = 10;
				kcal = met * weight * (secs/3600);
				
			}
			else if (speedmph <= 20) {
				met = 12;
				kcal = met * weight * (secs/3600);
			
			}
			else if (speedmph > 20) {
				met = 16;
				kcal = met * weight * (secs/3600);
				
			}
		
		
		
		
		// Energy Expended (kcal) = MET x Body Weight (kg) x Time (h)

		// OPPGAVE SLUTT
		
		return kcal;
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO
		// OPPGAVE - START 
		
		
		
		
		// Hint: hent hastigheter i speeds tabellen og tider i timestabellen
		// disse er definer i toppen av klassen og lese automatisk inn
		
		// OPPGAVE - SLUTT
		
		return totalkcal;
	}
	
	private static double WEIGHT = 80.0;
	
	// skriv ut statistikk for turen
	public void print() {
		
		// TODO
		// OPPGAVE - START
	
		
		// OPPGAVE - SLUT
	}
	
	// ekstraoppgaver
	public void climbs() {
		
	}
	
	public void maxClimb() {
		
	}
}
