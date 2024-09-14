SRC_DIR = src

BIN_DIR = out

MAIN_CLASS = principal.Main

LIBS = /nishome/u08387785938/pedagio/Pedagio/amqp-client-5.16.0.jar:/nishome/u08387785938/pedagio/Pedagio/slf4j-api-1.7.36.jar:/nishome/u08387785938/pedagio/Pedagio/slf4j-simple-1.7.36.jar

JAVAC = javac

JAVA = java

JAVAC_FLAGS = -d $(BIN_DIR) -cp $(LIBS)

JAVA_FLAGS = -cp "$(BIN_DIR):$(LIBS)"

SOURCES = $(shell find $(SRC_DIR) -name '*.java')

all: compile run

compile:
	@mkdir -p $(BIN_DIR)
	$(JAVAC) $(JAVAC_FLAGS) $(SOURCES)

run:
	$(JAVA) $(JAVA_FLAGS) $(MAIN_CLASS)

clean:
	@rm -rf $(BIN_DIR)

rebuild: clean all

