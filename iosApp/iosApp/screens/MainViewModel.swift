import SwiftUI
import shared

class PostsViewModel: ObservableObject {
    private let api: TypicodeApi
    @Published var posts: [shared.Post] = []
    
    init(api: TypicodeApi) {
        self.api = api
        loadPosts()
    }
    
    private func loadPosts() {
        api.loadPosts { data, error in
            DispatchQueue.main.async {
                if let posts = data {
                    self.posts = posts
                } else {
                    print(error?.localizedDescription ?? "Internet conection error.")
                }
            }
        }
    }
}
