# Welcome To EatsExplorer!

EatsExplorer is a dynamic and user-friendly Android application designed to enhance your dining experiences and make every meal memorable. Whether you’re looking to discover new restaurants, keep track of your favorites, or find the perfect place for your next culinary adventure, EatsExplorer is your perfect companion.

Our app comprises six key pages: Entry, Login, SignUp, Home, Restaurant Detail, and Favorites, each meticulously crafted to ensure a seamless and enjoyable user experience.

EatsExplorer is designed with the user in mind, ensuring that every feature and page is intuitive and easy to navigate. Our goal is to enrich your dining experiences, whether you’re discovering a hidden gem in your city or keeping track of your all-time favorite eateries. Join us on EatsExplorer and take your dining adventures to the next level!

[[Figma Link is HERE](https://www.figma.com/design/o6ycaP0VIkSMLmjK66niFo/Mobile-Project?node-id=0-1&t=nhIwdBu29vzrWHrb-0)]

## Work Distribution

### 1. Berat Kargın:
- **SignUp Screen:** Developed the user registration functionality, ensuring a smooth and secure sign-up process for new users.
- **Figma Design:** Contributed to the detailed designs and interactive prototypes for all screens using Figma, focusing on usability and aesthetic appeal.

### 2. Muhammet Eryılmaz:
- **Home Screen:** Developed the main dashboard where users can browse through restaurants, and add restaurants to their favorites. Implemented features such as search functionality and favorite buttons for easy restaurant management.
- **Figma Design:** Created initial designs and prototypes for all screens using Figma, ensuring a user-friendly and visually appealing interface.

### 3. Cenker Aydın:
- **Remaining Screens:** Developed all other screens, including Entry, Login, Restaurant Detail, and Favorites, ensuring consistent functionality and design across the application.
- **Final Report:** Compiled and wrote the final project report, detailing the development process, technologies used, and overall project outcomes.

# ENTRY PAGE

The Entry page of EatsExplorer welcomes users with a visually appealing design that features a captivating image representing the essence of culinary exploration. This page serves as the gateway to our app, offering two distinct buttons for user navigation: **Login** and **Sign Up**.

<img src="https://github.com/akdenizcse/cse234-23b-term-project-Restaurant-Finder/assets/112515788/e9781b1d-f3fe-47f5-95c4-be0a1128e619" alt="Entry Page Image" width="300" />

**Login Button:**  Users who already have an account can tap the Login button to proceed to the Login page, where they can access their personalized EatsExplorer experience.

**Sign Up Button:**  New users can tap the Sign Up button to create a new account using our secure Firebase authentication system, allowing them to start their journey with EatsExplorer.

By leveraging Firebase, we provide a secure and reliable way for users to register and log in, ensuring their data is safe and their experience is seamless.

# LOGIN PAGE

When a user taps the Login button on the Entry page, they are directed to the Login page. Here, users who already have an account can log in by entering their email and password.

<img src="https://github.com/akdenizcse/cse234-23b-term-project-Restaurant-Finder/assets/112515788/2b0a35bf-4d4c-4b40-98cb-841fa65aa4eb" alt="Login Page Image" width="300" />



**Email and Password Fields:**  Users input their registered email and password to access the app. If the entered credentials are correct, they are granted access to the EatsExplorer app.

**Error Message:**  If the email or password is incorrect, an error message is displayed, prompting the user to re-enter their credentials.

**Register Link:**  If the user does not have an account, they can tap the Register link at the bottom of the page. This link redirects them to the SignUp page, where they can create a new account using our secure Firebase authentication system.

The Login page ensures that users can seamlessly access their account while providing clear guidance and support in case of login errors or the need to register a new account.


# SIGN UP PAGE

When a user taps the Register link on the Login page or the Sign Up button on the Entry page, they are directed to the SignUp page. Here, new users can create an account using our secure Firebase authentication system.

The SignUp page features a clean and user-friendly design, making the registration process straightforward. The page includes the following elements:

<img src="https://github.com/akdenizcse/cse234-23b-term-project-Restaurant-Finder/assets/112515788/105a23b7-669f-49c1-bc6d-f57be19d8423" alt="Sign Up Page Image" width="300" />


**First Name and Last Name Fields:**  Users enter their first and last names to personalize their account.

**Email Field:**  Users provide their email address, which will be used for account verification and login.

**Password Field:**  Users create a secure password for their account. The password is masked for privacy, with an option to toggle visibility.

**Password Confirm Field:**  Users re-enter their password to ensure accuracy and prevent typos. This field is also masked with an option to toggle visibility.

**Register Button:**  After filling in the required information, users tap the Register button to create their account.

**Login Link:**  If a user already has an account, they can tap the “login” link to return to the Login page.

At the top, a welcoming message “Hey there” and a bold prompt “Create an account” guide users through the process. The combination of intuitive input fields and clear instructions ensures a smooth registration experience, allowing new users to join EatsExplorer with ease.


# Home Page

The Home page of EatsExplorer is designed to be the central hub where users can explore a variety of dining options. The layout is intuitive, making it easy for users to navigate and discover new restaurants. Here are the key features of the Home page:

<img src="https://github.com/akdenizcse/cse234-23b-term-project-Restaurant-Finder/assets/112515788/671879bc-3098-45a3-b855-b42e136e024c" alt="Home Page Image" width="300" />


**Search Bar:** At the top of the page, there’s a search bar where users can enter keywords to find specific restaurants. This feature allows for quick and efficient searches.

**Restaurant Listings:** Below the search bar, users are presented with a list of restaurants. Each restaurant entry includes:

- **Thumbnail Image**: A small image representing the restaurant, giving users a visual preview of the dining experience.
- **Restaurant Name**: The name of the restaurant, prominently displayed for easy identification.
- **Price**: The average price range for the restaurant, helping users gauge the affordability.
- **Date**: The date the restaurant was added to the list or the date of a specific event or update related to the restaurant.
- **Favorite Icon**: A heart icon next to each restaurant allows users to mark it as a favorite. This enables users to easily save and access their preferred dining spots.

**Navigation Bar:** At the bottom of the page, there's a navigation bar with two main icons:

- **Home Icon**: Takes users back to the Home page from any other part of the app.
- **Favorite Icon**: Directs users to the Favorites page, where they can view all the restaurants they have marked as favorites.

The Home page provides a comprehensive and user-friendly interface that makes discovering and selecting restaurants enjoyable and straightforward. It combines visual appeal with functional elements to enhance the overall user experience in the EatsExplorer app.


# Restaurant Detail Page

The Restaurant Detail page provides comprehensive information about a selected restaurant, giving users a detailed view of what they can expect. This page ensures users have all the necessary details to make an informed decision about their dining experience. 

<img src="https://github.com/akdenizcse/cse234-23b-term-project-Restaurant-Finder/assets/112515788/3dd53cbd-c071-4833-8e0b-e62f784c3def" alt="Restaurant Detail Page Image" width="300" />


The layout is clean and intuitive, featuring the following elements:

**Back Navigation**: At the top of the page, there is a back arrow icon that allows users to return to the previous page (Home) easily.

**Restaurant Image**: A large, appealing image at the top of the page showcases the restaurant's ambiance and cuisine, giving users a visual taste of what the restaurant offers.

**Restaurant Detail**: Below the image, key details about the restaurant are displayed:

- **Name**: The name of the restaurant, prominently shown to avoid any confusion.
- **Price**: The average price range for the restaurant, helping users understand the cost of dining.
- **Date**: The date the restaurant was added or a notable date related to the restaurant.
- **Location**: The location of the restaurant, including the area and city (Konyaaltı / Antalya), so users can quickly know where it is situated.
- **Popular Dishes**: A section highlighting the restaurant's popular dishes.

**Navigation Bar**: At the bottom of the page, there is a navigation bar with icons for:

- **Home**: Takes users back to the Home page.
- **Favorite**: Directs users to the Favorites page, where they can view their saved restaurants.

This detailed and visually appealing page helps users get a complete understanding of the restaurant, from its location and pricing to the popular dishes it serves, enhancing their overall experience with EatsExplorer.

# Favorite Restaurant Page

This page displays a screen from an app titled "My Favorite Restaurants." On this page, you can see a list of your favorite restaurants. 

<img src="https://github.com/akdenizcse/cse234-23b-term-project-Restaurant-Finder/assets/112515788/81a14cd7-e510-4cff-8a19-07b17a41a656" alt="Restaurant Favorite Page Image" width="300" />



Each restaurant card contains the following information:

- **Restaurant Name**: The name of the restaurant, such as "Adana Kebap" and "Urfa Sofrası."
- **Price**: The amount spent at the restaurant, for example, "$25.0" and "$2.0."
- **Date**: The date the restaurant was visited, for instance, "2024-05-11" and "2024-05-12."
- **Restaurant Photo**: An image of the restaurant.

Additionally, each restaurant card has a heart icon in the top left corner, indicating that the restaurant is marked as a favorite.


