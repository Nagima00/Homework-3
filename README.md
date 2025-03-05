README - MUD Game (Builder & Prototype Patterns)

Project Description

This project demonstrates the use of Builder and Prototype patterns to create game objects. The Builder pattern helps construct complex objects step by step, while the Prototype pattern makes it easier to duplicate existing objects efficiently.

Implemented Patterns

1. Builder Pattern

This pattern is used to build a Dungeon object, which consists of the following components:

Name

List of Rooms

List of NPCs

Classes Involved:

IDungeonBuilder - Builder interface.

SimpleDungeonBuilder - Concrete implementation of the Builder interface.

Dungeon - The final product.

2. Prototype Pattern

This pattern is used to quickly clone Room and NPC objects, allowing easy duplication of existing entities.

Classes Involved:

CloneableGameEntity - Interface for all cloneable objects.

Room - A room that can be cloned.

NPC - A non-player character that can be cloned.
