# The Simpsons MCP

This is a Model Context Protocol (MCP) server that provides tools for interacting with The Simpsons content. It integrates with various Simpsons APIs to fetch episodes, quotes, and other related information.

## Features

The server provides the following tools:

1. **Get Random Good Episode** (`Get_a_Simpsons_random_good_episode`)
   - Returns a random episode that is marked as "good"
   - Includes episode details like title, description, release date, and links to various platforms

2. **Get Specific Episode** (`Get_Simsons_episode`)
   - Retrieves information about a specific episode by season and episode number
   - Returns comprehensive episode details including Disney+ and Simpsons World links

3. **Get Season Episodes** (`Get_Simpsons_seasons_episodes`)
   - Lists all episodes from a specified season
   - Each episode includes full details and streaming links

4. **Get Random Quote** (`Get_Simpsons_random_quote`)
   - Fetches a random quote from The Simpsons
   - Includes the character name, image, and character direction

## Example Usage

Here's an example of getting the episodes from Season 2:

```json
{
    "title": "Bart Gets an F",
    "description": "Bart must pass a critical history test or he will be held back a grade.",
    "release_date": "1990-10-11",
    "season": 2,
    "episode": 1,
    "disneyplus_url": "https://www.disneyplus.com/video/4050d194-f1a6-47d4-bc1b-76b8245ed113"
    // ... other episode details
}
```

## Technical Details

- Built with Spring Boot and Spring AI
- Uses Spring AI's MCP Server implementation
- Integrates with:
  - simpsonsoptimizer.com for episode data
  - thesimpsonsquoteapi.glitch.me for quotes

## Running the Server

1. Build the project:
   ```bash
   mvn clean package
   ```

2. Run the jar:
   ```bash
   java -jar target/simpsonsmcp-0.0.1-SNAPSHOT.jar
   ```

3. Configure in VS Code:
   The server can be used with VS Code's MCP extension using the provided `mcp.json` configuration.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Code

Just the tests were created by ai.
