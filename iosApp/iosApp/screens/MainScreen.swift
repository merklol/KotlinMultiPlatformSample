import SwiftUI
import shared

struct MainScreen: View {
    @ObservedObject private(set) var viewModel = PostsViewModel(api: TypicodeApi())
    
	var body: some View {
        List(viewModel.posts, id: \.id) { post in
            Post(title: post.title, content: post.body)
        }
        .frame(maxWidth: .infinity)
        .listStyle(.plain)
	}
}

struct MainScreen_Previews: PreviewProvider {
    static var previews: some View {
        MainScreen()
    }
}
