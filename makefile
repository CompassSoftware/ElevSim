
JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher

default:
	@echo "usage: make target"

compile: Elevator.java ElevatorTest.java $(JUNIT5_JAR)
	        javac -cp .:$(JUNIT5_JAR) ElevatorTest.java
		        javac Elevator.java

clean:
	        rm -f *~
		        rm -f Elevator*.class
		

test: $(JUNIT5_JAR)
	        java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 


