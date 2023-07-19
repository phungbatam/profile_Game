#include "Main_menu.h"

MainMenu::MainMenu(float width, float height)
{
	if (!font.loadFromFile("Fontter_Game/AliquamItalic-1ZOB.ttf"))
	{
		std::cout << "No not file :((";
	}

	// Main option Play Game
	mainMenu[0].setFont(font);
	mainMenu[0].setFillColor(sf::Color::White);
	mainMenu[0].setString("Play Game");
	mainMenu[0].setCharacterSize(40);
	mainMenu[0].setPosition(400, 100);

	mainMenu[1].setFont(font);
	mainMenu[1].setFillColor(sf::Color::White);
	mainMenu[1].setString("Option");
	mainMenu[1].setCharacterSize(40);
	mainMenu[1].setPosition(400, 150);

	mainMenu[2].setFont(font);
	mainMenu[2].setFillColor(sf::Color::White);
	mainMenu[2].setString("About");
	mainMenu[2].setCharacterSize(40);
	mainMenu[2].setPosition(400,200);

	mainMenu[3].setFont(font);
	mainMenu[3].setFillColor(sf::Color::White);
	mainMenu[3].setString("EXIT");
	mainMenu[3].setCharacterSize(40);
	mainMenu[3].setPosition(400,250);

	MainMenuSlected = -1;
};

MainMenu::~MainMenu()
{

};

void MainMenu::draw(sf::RenderWindow& window)
{
	for (int i = 0; i < Max_main_menu; ++i)
	{
		window.draw(mainMenu[i]);
	}
}

void MainMenu::MoveUp()
{

	if (MainMenuSlected - 1 >= 0)
	{
		mainMenu[MainMenuSlected].setFillColor(sf::Color::White);
		MainMenuSlected--;
		if (MainMenuSlected == -1)
		{
			MainMenuSlected = 3;
		}

		mainMenu[MainMenuSlected].setFillColor(sf::Color::Blue);
	}

}

void MainMenu::MoveDown()
{
	if (MainMenuSlected + 1 <= Max_main_menu)
	{
		mainMenu[MainMenuSlected].setFillColor(sf::Color::White);
		MainMenuSlected++;
		if (MainMenuSlected == 4)
		{
			MainMenuSlected = 0;
		}
		mainMenu[MainMenuSlected].setFillColor(sf::Color::Blue);
	}
}